import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class MostCommonThreeWordSequences {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide one or more file names as input.");
            System.exit(1);
        }
        Map<String, Integer> frequency = new HashMap<>();
        for (String fileName : args) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    StringTokenizer st = new StringTokenizer(sb.toString().replaceAll("[^a-zA-Z ]", "").toLowerCase(), " ");
                    String prev = null, curr = null;
                    while (st.hasMoreTokens()) {
                        String word = st.nextToken();
                        if (prev != null && curr != null) {
                            String threeWords = prev + " " + curr + " " + word;
                            frequency.put(threeWords, frequency.getOrDefault(threeWords, 0) + 1);
                        }
                        prev = curr;
                        curr = word;
                    }
                    sb = new StringBuilder();
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Map<String, Integer> sortedFrequency = frequency.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            count++;
            if (count == 100) {
                break;
            }
        }
    }
}

