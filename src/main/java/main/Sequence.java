package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Sequence {
    public static void main(String[] args) {

//        System.out.println(createPhrases(args[0]));
        createPhrases("It's a trap that I cannot!");



    }



    private static void createPhrases(String text) {
        // Split text into individual words, separated by space
        String[] words = text.split(" ");

        StringBuilder phrase = new StringBuilder();
        for (int i = 0; i < words.length - 3; i++) {
            phrase.append(words[i] + " ");
        }
        System.out.println(phrase);
    }

}
