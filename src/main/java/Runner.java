import algorithm.Algorithm;
import exceptions.InvalidWordDetailsException;
import model.WordDetails;
import service.UserService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Runner {
    public static void main(String[] args) {
        try {
            WordDetails wordDetails = UserService.getWordDetailsFromUser();
            InputStream dictionaryFile = new FileInputStream("src/main/java/data/dictionary.txt");
            Algorithm algorithm = new Algorithm();
            try {
                algorithm.m7naKAROTKA(dictionaryFile, wordDetails);
                System.out.println("Words saved successful!");
            } catch (InvalidWordDetailsException e) {
                System.out.println(e.getMessage());
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid details!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
