import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {

        //        String path = "/Users/justinsixsmith/IdeaProjects/kpr3-coding-challenge/src/main/resources/texts/moby-dick.txt";

        List<File> files = new ArrayList<>();
        String fileContent = "";

        for (String path :
                args) {
            files.add(new File(path));
        }

        for (File file :
                files) {
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    fileContent = fileContent.concat(scanner.nextLine()) + " \n";
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

//        // Scan a file taken in as args
//        File file = new File(args[0]);
//        String fileContent = "";
//
//        try {
//            Scanner scanner = new Scanner(file);
//
//            while (scanner.hasNextLine()) {
//                fileContent = fileContent.concat(scanner.nextLine()) + " \n";
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        // Make an array out of the file with each element consisting of three sequential words
        ArrayList<String> phraseArray = createPhraseArray(fileContent);

        // Count how many times each phrase shows up in that array
        HashMap<String, Integer> phraseCounts = countPhrases(phraseArray);

        // Sort and print out the top 100 duplicated phrases
        topOneHundred(phraseCounts);

    }


    public static ArrayList<String> createPhraseArray(String text) {
        // Split text into individual words
        String[] words = text.split(" ");

        // Initialize array of three sequential word phrases
        ArrayList<String> phrases = new ArrayList<>();

        // Iterate over words array
        for (int i = 0; i < words.length - 2; i++) {
            String trimWord1 = removeSingleQuote(words[i]);
            String trimWord2 = removeSingleQuote(words[i + 1]);
            String trimWord3 = removeSingleQuote(words[i + 2]);

            // Trim spaces around each word, make lower case, and remove punctuation
            trimWord1 = trimWord1.toLowerCase().trim().replaceAll("[^a-z-']", "");
            trimWord2 = trimWord2.toLowerCase().trim().replaceAll("[^a-z-']", "");
            trimWord3 = trimWord3.toLowerCase().trim().replaceAll("[^a-z-']", "");

            // Create new three words strings
            String phrase = trimWord1 + " " + trimWord2 + " " + trimWord3;

            // Add to the array
            phrases.add(phrase);
        }
        return phrases;
    }

    private static String removeSingleQuote(String word) {
        char firstChar = word.charAt(0);
        char lastChar = word.charAt(word.length() - 1);
        String subWord = "";

        if (firstChar == '\'') {
            System.out.println("Open single quote");
            subWord = word.substring(1);
            System.out.println(subWord);
        }
        if (lastChar == '\'') {
            System.out.println("Close sing quote");
            subWord = word.substring(0, word.length()-1);
            System.out.println(subWord);
        } else {
            subWord = word;
        }
        return subWord;
    }

    public static HashMap<String, Integer> countPhrases(ArrayList<String> phrases) {
        // Create Hashmap for storing key and value of times found
        HashMap<String, Integer> phraseCounts = new HashMap<>();

        for (String phrase : phrases) {
            //if the phrase is already in the map, increase the count
            if (phraseCounts.containsKey(phrase)) {
                phraseCounts.put(phrase, phraseCounts.get(phrase) + 1);
            } else {
                phraseCounts.put(phrase, 1);
            }
        }
        phraseCounts.remove("  ");
        return phraseCounts;
    }

    private static void topOneHundred(Map<String, Integer> map) {
        // List w/top 100 keys
        List<String> keys = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(100).map(Map.Entry::getKey).collect(Collectors.toList());
        // List w/top 100 values
        List<Integer> values = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(100).map(Map.Entry::getValue).collect(Collectors.toList());

        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + " - " + values.get(i));
        }
    }

}

