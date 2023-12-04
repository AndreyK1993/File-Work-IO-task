package app;

import app._01_write_service.FileWriteService;
import app._02_read_service.FileReadService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
            Choose an action:
            1. Create and save the file
            2. Read the file
            3. Go out
        """);

            int choice = scanner.nextInt();
            scanner.nextLine(); // очистити буфер після nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Enter a file name (with extension): ");
                    String writeFileName = scanner.nextLine();
                    System.out.print("Enter text content: ");
                    String writeContent = scanner.nextLine();
                    FileWriteService.writeToFile(writeFileName, writeContent);
                    break;
                case 2:
                    System.out.print("Enter the name of the file to read (without extension): ");
                    String readFileName = scanner.nextLine();
                    String fileContent = FileReadService.readFromFile(readFileName);
                    System.out.println("File contents:");
                    System.out.println(fileContent);
                    break;
                case 3:
                    System.out.println("The program is complete.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice. Try again.");
            }
        }
    }
}
