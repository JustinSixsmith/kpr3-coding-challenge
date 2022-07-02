import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        // Add the file path strings to a file path list
        List<File> filePaths = addFilePaths(args);

        // Scan the files and concat each line to the content string
        String fileContent = makeABigString(filePaths);

        // Split the words and clean them up
        String[] singleWords = separateWords(fileContent);

        // Make a phase list from the individual words, with each element consisting of three sequential words
        LinkedList<String> phraseList = createPhraseList(singleWords);

        // Count how many times each phrase shows up in that array
        HashMap<String, Integer> phraseCounts = countPhrases(phraseList);

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

    public static String makeABigString(List<File> filePaths) {
        String fileContent = "";
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
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return fileContent;
    }

    public static String[] separateWords(String fileContent) {
        // Remove punctuation
        String cleanString = fileContent.toLowerCase().replaceAll("[^a-z0-9-' ]", "");

        // Split text into individual words
        return cleanString.split(" ");
    }

    public static LinkedList<String> createPhraseList(String[] words) {
        LinkedList<String> phrases = new LinkedList<>();

        // Remove single quotes
        for (String word :
                words) {
            if (!word.equals("")) {
                removeSingleQuotes(word);
            }
        }

        // Each element in the list is a phrase with three consecutive words
        for (int i = 0; i < words.length - 2; i++) {
            String phrase = null;
            if (!words[0].equals("")) {
                phrase = words[i] + " " + words[i + 1] + " " + words[i + 2];
            }
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

    public static HashMap<String, Integer> countPhrases(LinkedList<String> phrases) {
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
        phraseCounts.remove("");
        phraseCounts.remove(" ");
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
