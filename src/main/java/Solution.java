import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        // Initialize a string that will hold all the text
        String fileContent = "";

        // Add the file paths to a file path list
        List<File> filePaths = addFilePaths(args);

        // Scan each file and concat each line to the content string
        fileContent = makeABigString(filePaths, fileContent);

        // Make an array out of the file with each element consisting of three sequential words
        ArrayList<String> phraseArray = createPhraseArray(fileContent);

        // Count how many times each phrase shows up in that array
        HashMap<String, Integer> phraseCounts = countPhrases(phraseArray);

        // Sort and print out the top 100 duplicated phrases
        topOneHundred(phraseCounts);

    }

    public static List<File> addFilePaths(String[] args) {
        List<File> filePaths = new ArrayList<>();
        for (String path :
                args) {
            filePaths.add(new File(path));
        }
        return filePaths;
    }

    public static String makeABigString(List<File> filePaths, String fileContent) {
        for (File file :
                filePaths) {
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String nextLine = scanner.nextLine();
                    // Check to see if line is empty
                    if (!Objects.equals(nextLine, "")) {
                        // If the last character is a hyphen, remove the hyphen and concat to next line w/no space
                        if (nextLine.charAt(nextLine.length() - 1) == '-') {
                            nextLine = nextLine.substring(0, nextLine.length() - 1);
                            fileContent = fileContent.concat(nextLine);
                            // Otherwise, concat lines with a space
                        } else {
                            fileContent = fileContent.concat(nextLine) + " ";
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return fileContent;
    }

    public static ArrayList<String> createPhraseArray(String text) {
        // Split text into individual words
        String[] words = text.split(" ");

        // Initialize array of three sequential word phrases
        ArrayList<String> phrases = new ArrayList<>();

        // Iterate over words array
        for (int i = 0; i < words.length - 2; i++) {

            // Trim spaces around each word, make lower case, and remove punctuation
            String trimWord1 = words[i].toLowerCase().trim().replaceAll("[^a-z0-9-']", "");
            String trimWord2 = words[i + 1].toLowerCase().trim().replaceAll("[^a-z0-9-']", "");
            String trimWord3 = words[i + 2].toLowerCase().trim().replaceAll("[^a-z0-9']", "");

            trimWord1 = removeSingleQuotes(trimWord1);
            trimWord2 = removeSingleQuotes(trimWord2);
            trimWord3 = removeSingleQuotes(trimWord3);

            // Create new three words strings
            String phrase = trimWord1 + " " + trimWord2 + " " + trimWord3;

            // Add to the array
            phrases.add(phrase);
        }
        return phrases;
    }

    static String removeSingleQuotes(String word) {
            if (word.charAt(0) == '\'') {
                word = word.substring(1);
            }
            if (word.charAt(word.length() - 1) == '\'') {
                word = word.substring(0, word.length() - 1);
            }
        return word;
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

