package _02_read_service;

import utils.Constants;

import java.io.File;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileReadService {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = getFileNameFromUser(scanner);
        String content = getContentFromUser(scanner);
        saveToFile(fileName, content);
        String filePath = Constants.BASE_PATH_OUT + fileName + ".txt";
        String fileContent = readFileContent(filePath);
        displayFileContent(fileContent);
    }

    private static String getFileNameFromUser(Scanner scanner) {
        System.out.print("Enter the name of the file (without extension): ");
        return scanner.nextLine();
    }

    private static String getContentFromUser(Scanner scanner) {
        System.out.print("Enter the text content of the file: ");
        return scanner.nextLine();
    }

    private static void saveToFile(String fileName, String content) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(Constants.BASE_PATH_OUT + fileName + ".txt")) {
            byte[] bytes = content.getBytes();
            fileOutputStream.write(bytes);
            System.out.println("The file has been successfully created and saved.");
        } catch (IOException e) {
            System.err.println("\n" +
                    "Error when creating or writing a file: " + e.getMessage());
        }
    }

    private static String readFileContent(String filePath) {
        File file = new File(filePath);
        try (FileReader fr = new FileReader(file)) {
            int i;
            StringBuilder stringBuilder = new StringBuilder();
            while ((i = fr.read()) != -1)
                stringBuilder.append((char) i);
            return stringBuilder.toString();
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }

    private static void displayFileContent(String content) {
        System.out.println("Contents of the file:");
        System.out.println(content);
    }
}
