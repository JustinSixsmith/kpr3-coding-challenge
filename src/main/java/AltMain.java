import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AltMain {
    public static void main(String[] args) {
        // Create list of file paths
        List<File> filePaths = null;

        // Check to see if file paths were provided from command line
        // If not, scan file paths from stdin and assign to args
        if (args.length == 0) {
            Scanner scanner = null;
            scanner = new Scanner(System.in);
            args = new String[]{scanner.nextLine()};
            scanner.close();
        }

        for (String filePath : args) {
            try {
                String text = new String(Files.readAllBytes(Paths.get(filePath)));
                Map<String, Integer> fileMap = getThreeWordSequences(text);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            filePaths.add(new File(filePath));
        }
    }

    private static Map<String, Integer> getThreeWordSequences(String text) {
        // create a Map of three
    }
}