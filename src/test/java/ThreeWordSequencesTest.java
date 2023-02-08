import org.junit.Test;
import java.io.*;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class ThreeWordSequencesTest {
    @Test
    public void testThreeWordSequences() throws IOException {
        // Prepare the input text
        String input = "This is a test.\nThis is another test.";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Capture the output from the program
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Run the program
        ThreeWordSequences.main(new String[0]);

        // Verify the output
        Map<String, Integer> expected = new HashMap<>();
        expected.put("this is a", 1);
        expected.put("is a test", 1);
        expected.put("this is another", 1);
        expected.put("is another test", 1);
        Map<String, Integer> actual = new HashMap<>();
        Scanner scanner = new Scanner(out.toString());
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(": ");
            actual.put(parts[0], Integer.parseInt(parts[1]));
        }
        assertEquals(expected, actual);
    }
}
