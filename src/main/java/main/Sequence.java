package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Sequence {
    public static void main(String[] args) {

        System.out.println(createPhraseArray("It's a trap, that I cannot avoid! It's a trap,"));

    }


    public static ArrayList<String> createPhraseArray(String text) {
        // Split text into individual words
        String[] words = text.split(" ");

        // Initialize array of three sequential word phrases
        ArrayList<String> phrases = new ArrayList<>();

        // Iterate over words array
        for (int i = 0; i < words.length - 2; i++) {

            // Trim spaces around each word, make lower case, and remove punctuation
            String trimWord1 = words[i].toLowerCase().trim().replaceAll("[^a-z ]", "");
            String trimWord2 = words[i + 1].toLowerCase().trim().replaceAll("[^a-z ]", "");
            String trimWord3 = words[i + 2].toLowerCase().trim().replaceAll("[^a-z ]", "");

            // Create new three words strings
            String phrase = trimWord1 + " " + trimWord2 + " " + trimWord3;

            // Add to the array
            phrases.add(phrase);
        }

        // Create new array just for duplicate strings
        Set<String> duplicates = new HashSet<>();

        for (String phrase : phrases) {
            if (!duplicates.add(phrase)) {
                System.out.println("ONE");
            }
        }

        return phrases;
    }




}

