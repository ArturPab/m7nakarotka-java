package service;

import model.WordDetails;

import java.util.Scanner;

public class UserService {

    /**
     * @return word's details with word's length and substring's length
     */
    public static WordDetails getWordDetailsFromUser() {
        Scanner scanner = new Scanner(System.in);

        WordDetails wordDetails = new WordDetails();
        System.out.print("Enter word length: ");
        int wordLength = scanner.nextInt();

        System.out.print("Enter substring length: ");
        int substringLength = scanner.nextInt();

        wordDetails.setWordLength(wordLength);
        wordDetails.setSubstringLength(substringLength);
        scanner.close();

        return wordDetails;
    }
}
