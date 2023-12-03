package _01_write_service;

import utils.Constants;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class FileWriteService {
    public static void writeToFile(String fileName, String content) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(
                Paths.get(Constants.BASE_PATH_OUT, fileName).toString())) {
            byte[] bytes = content.getBytes();
            fileOutputStream.write(bytes);
            System.out.println("File created and saved successfully.");
        } catch (IOException e) {
            System.err.println("Error creating or writing file: " + e.getMessage());
        }
    }
}
