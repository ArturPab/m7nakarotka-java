package service;

import model.WordDetails;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserService {

    public static WordDetails getWordDetailsFromUser() {
        Scanner scanner = new Scanner(System.in);
        try {
            WordDetails wordDetails = new WordDetails();
            System.out.print("Enter word length: ");
            int wordLength = scanner.nextInt();

            System.out.print("Enter substring length: ");
            int substringLength = scanner.nextInt();

            wordDetails.setWordLength(wordLength);
            wordDetails.setSubstringLength(substringLength);
            scanner.close();

            return wordDetails;
        } catch (InputMismatchException e) {
            System.err.println("Wrong type of number!");
        }
        return null;
    }
}
