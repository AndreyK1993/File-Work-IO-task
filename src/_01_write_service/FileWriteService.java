package _01_write_service;

import utils.Constants;

import java.io.FileWriter;

public class FileWriteService {
    public static void main(String[] args) {

        String myFile = "records_01.txt";
        String myText = "Hello! This is our file.";

        // try-with-resources
        try(FileWriter fw =
                    new FileWriter(Constants.BASE_PATH_OUT + "/" + myFile)) {
            fw.write(myText);
            System.out.println("Success.");
        } catch (Exception e) {
            System.out.println("Something went wrong :(" + e.getMessage());
        }
    }
}
