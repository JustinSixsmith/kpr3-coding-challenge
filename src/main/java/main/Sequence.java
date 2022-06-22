package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Sequence {
    public static void main(String[] args) {

//        System.out.println(createPhrases(args[0]));
        System.out.println(createPhrases("It's a trap!"));


    }



    private static ArrayList<String> createPhrases(String text) {
        // Split text into individual words, separated by space
        String[] words = text.split(" ");
        // Initialize phrase for each three word sequence
        StringBuilder phrase = new StringBuilder();
        // Initialize list for three word phrases
        ArrayList<String> phrases = new ArrayList<>();
        // Create three word phrases from words, in sequence
        for (int i = 0; i == words.length - 1; i++) {
            phrase.append(words[i]);
        }
        phrases.add(phrase.toString());
        return phrases;
    }

}
