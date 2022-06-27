import java.io.*;
import java.util.*;

public class Sequence {
    public static void main(String[] args) {

        File file = new File(args[0]);
        String fileContent = "";

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                fileContent = fileContent.concat(scanner.nextLine()) + "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        createPhraseArray(fileContent);

        String path = "/Users/justinsixsmith/IdeaProjects/kpr3-coding-challenge/src/main/resources/texts/moby-dick.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            System.out.println(reader.readLine());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        createPhraseArray("It's a trap, that I cannot avoid! It's a trap! It's a trap, that I cannot avoid! It's a trap! ");

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

//        ArrayList<Map.Entry<String, Integer>> phraseList = new ArrayList<>(phraseCounts.entrySet());
//
//        Collections.sort(phraseList, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return o.getValue() - o2.getValue();
//            }
//        });

        //sort array

        //print out results
        System.out.println(phraseCounts);
        return phrases;
    }


}

