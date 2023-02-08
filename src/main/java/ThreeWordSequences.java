import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ThreeWordSequences {
    private static Map<String, Integer> getThreeWordSequences(String text) {
        text = text.toLowerCase().replaceAll("[^a-zA-Z0-9\\s']", "");
        String[] words = text.split("\\s+");
        Map<String, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < words.length - 2; i++) {
            String threeWords = words[i] + " " + words[i + 1] + " " + words[i + 2];
            if (threeWords.contains("'")) {
                continue;
            }
            frequencies.put(threeWords, frequencies.getOrDefault(threeWords, 0) + 1);
        }
        return frequencies;
    }


    public static Map<String, Integer> getThreeWordSequences(String[] files) throws IOException {
        Map<String, Integer> frequencies = new HashMap<>();
        for (String file : files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Map<String, Integer> sequences = getThreeWordSequences(line);
                    for (Map.Entry<String, Integer> entry : sequences.entrySet()) {
                        frequencies.put(entry.getKey(), frequencies.getOrDefault(entry.getKey(), 0) + entry.getValue());
                    }
                }
            }
        }
        return frequencies;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        if (args.length == 0) {
            System.out.println("Please provide at least one file path as a command-line argument.");
            return;
        }
        for (String filePath : args) {
            try {
                String text = new String(Files.readAllBytes(Paths.get(filePath)));
                Map<String, Integer> fileMap = getThreeWordSequences(text);
                for (Map.Entry<String, Integer> entry : fileMap.entrySet()) {
                    String threeWords = entry.getKey();
                    int count = entry.getValue();
                    map.put(threeWords, map.getOrDefault(threeWords, 0) + count);
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading the file '" + filePath + "': " + e.getMessage());
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        int count = 0;
        for (Map.Entry<String, Integer> entry : list) {
            if (count >= 100) {
                break;
            }
            System.out.println(entry.getKey() + ": " + entry.getValue());
            count++;
        }
    }
}
