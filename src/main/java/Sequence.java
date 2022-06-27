import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Sequence {
    private static final boolean DESC = false;

    public static void main(String[] args) {

        // Scan a file taken in as args
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

        // Make an array out of the file with each element consisting of three sequential words
        ArrayList<String> phraseArray = createPhraseArray(fileContent);

        // Count how many times each phrase shows up in that array
        HashMap<String, Integer> phraseCounts = countPhrases(phraseArray);

        // Sort the HashMap by values
        Map<String, Integer> sortedMapDesc = sortByValue(phraseCounts, DESC);

        // Print out the sorted phrases
        printMap(sortedMapDesc);


//        String path = "/Users/justinsixsmith/IdeaProjects/kpr3-coding-challenge/src/main/resources/texts/moby-dick.txt";
//
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(path));
//            System.out.println(reader.readLine());
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        createPhraseArray("It's a trap, that I cannot avoid! It's a trap! It's a trap, that I cannot avoid! It's a trap! ");

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
        return phrases;
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
        return phraseCounts;
    }

    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap, final boolean order) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        return list.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));

    }

    private static void printMap(Map<String, Integer> map) {
        map.forEach((key, value) -> System.out.println(key + " " + value));

    }


}

