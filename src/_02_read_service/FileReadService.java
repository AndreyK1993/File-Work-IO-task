package _02_read_service;

import utils.Constants;
import java.nio.file.Paths;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReadService {

    public static String readFromFile(String fileName) {
        String filePath = Paths.get(Constants.BASE_PATH_OUT, fileName + ".txt").toString();
        StringBuilder content = new StringBuilder();
        try (FileReader fr = new FileReader(filePath)) {
            int data;
            while ((data = fr.read()) != -1) {
                content.append((char) data);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return content.toString();
    }
}
 //