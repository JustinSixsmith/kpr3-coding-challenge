package main;

import java.util.ArrayList;
import java.util.Locale;

public class Sequence {
    public static void main(String[] args) {

//        System.out.println(createPhrases(args[0]));
        System.out.println(createPhraseArray("It's a trap that I cannot avoid!"));

    }


    public static ArrayList<String> createPhraseArray(String text) {

        // Split text into individual words, separated by space
        String[] words = text.split(" ");

        ArrayList<String> phrases = new ArrayList<>();
        for (int i = 0; i < words.length - 2; i++) {
            phrases.add(words[i] + " " + words[i + 1] + " " + words[i + 2]);
        }

        for (String phrase : phrases) {
            if (phrase.length() == 11) {
                System.out.println("ONE");
            }
        }

        return phrases;
    }



}

