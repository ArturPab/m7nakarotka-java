package algorithm;

import exceptions.InvalidWordDetailsException;
import model.WordDetails;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Algorithm {

    public void m7naKAROTKA(InputStream dictionaryFile, WordDetails wordDetails) throws InvalidWordDetailsException {
        if(!isWordDetailsCorrect(wordDetails)) {
            throw new InvalidWordDetailsException("Invalid details!");
        }

        HashMap<String, String> substrings = new HashMap<>();
        List<String> words = new ArrayList<>();
        findWordsByDetails(substrings, words, wordDetails, dictionaryFile);
        saveCorrectWordsInFile(substrings, words, wordDetails.getSubstringLength());
    }

    /**
     *
     * @param substrings with length given by user
     * @param words with length given by user
     * @param substringLength given by user
     * method saves to result's file all words that are consistent with the task
     */
    private void saveCorrectWordsInFile(HashMap<String, String> substrings, List<String> words, int substringLength) {
        File outFile = new File("src/main/java/data/result.txt");
        try {
            PrintWriter out = new PrintWriter(new FileWriter(outFile, StandardCharsets.UTF_8));
            for(String word: words) {
               if(isSubstringProperly(word.substring(word.length()-substringLength), substrings)) {
                   out.println(word);
               }
            }
            out.close();
        } catch (IOException e) {
            System.err.println("Result file not found!");
        }

    }

    /**
     *
     * @param substring from substrings
     * @param substrings
     * @return true if substring ONLY READ AS REVERSE exists in dictionary
     */
    private boolean isSubstringProperly(String substring, HashMap<String, String> substrings) {
        String reversedSubstring = new StringBuilder().append(substring).reverse().toString();
        if(substrings.containsKey(reversedSubstring)) {
            return (!substrings.containsKey(substring));
        }
        return false;
    }

    /**
     *
     * @param substrings - empty HashMap
     * @param words - empty list
     * @param wordDetails - details with word's and substring's length, which have to be searched
     * @param dictionaryFile with all words
     * method searches for words consistent with the details
     */
    private void findWordsByDetails(HashMap<String, String> substrings, List<String> words, WordDetails wordDetails, InputStream dictionaryFile) {
        Scanner scanner = new Scanner(dictionaryFile, StandardCharsets.UTF_8);
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine().trim();
            if(hasCharsEnough(word.length(), wordDetails.getWordLength())) {
                words.add(word);
            } else if (hasCharsEnough(word.length(), wordDetails.getSubstringLength())) {
                substrings.put(word, word);
            }
        }
    }

    /**
     *
     * @return if given length equals to word's length
     */
    private boolean hasCharsEnough(int length, int wordLength) {
        return length==wordLength;
    }

    private boolean isWordDetailsCorrect(WordDetails wordDetails) {
        return wordDetails.getWordLength() > wordDetails.getSubstringLength();
    }
}
