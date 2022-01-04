import algorithm.Algorithm;
import exceptions.InvalidWordDetailsException;
import model.WordDetails;
import service.UserService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Runner {
    public static void main(String[] args) throws InvalidWordDetailsException, FileNotFoundException {
        WordDetails wordDetails = UserService.getWordDetailsFromUser();
        InputStream dictionaryFile = new FileInputStream("src/main/java/data/dictionary.txt");
        Algorithm algorithm = new Algorithm();
        algorithm.m7naKAROTKA(dictionaryFile, wordDetails);
    }
}
