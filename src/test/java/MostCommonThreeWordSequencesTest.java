import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MostCommonThreeWordSequencesTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void testNoInput() throws Exception {
        String[] args = {};
        System.setOut(new PrintStream(outContent));
        MostCommonThreeWordSequences.main(args);
        assertEquals("Please provide one or more file names as input.", outContent.toString().trim());
    }

    @Test
    public void testSingleInput() throws Exception {
        File file = new File("sample.txt");
        file.createNewFile();
        String[] args = {file.getAbsolutePath()};
        System.setOut(new PrintStream(outContent));
        MostCommonThreeWordSequences.main(args);
        assertTrue(outContent.toString().trim().isEmpty());
    }

    @Test
    public void testMultipleInputs() throws Exception {
        File file1 = new File("sample1.txt");
        file1.createNewFile();
        File file2 = new File("sample2.txt");
        file2.createNewFile();
        String[] args = {file1.getAbsolutePath(), file2.getAbsolutePath()};
        System.setOut(new PrintStream(outContent));
        MostCommonThreeWordSequences.main(args);
        assertTrue(outContent.toString().trim().isEmpty());
    }

    @Test
    public void testOutput() throws Exception {
        File file = new File("sample.txt");
        file.createNewFile();
        String text = "this is a test. This is another test.";
        Map<String, Integer> expected = new HashMap<>();
        expected.put("this is a", 2);
        expected.put("is a test", 2);
        expected.put("a test this", 2);
        expected.put("test this is", 2);
        expected.put("another test this", 1);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.write(text);
        }
        String[] args = {file.getAbsolutePath()};
        System.setOut(new PrintStream(outContent));
        MostCommonThreeWordSequences.main(args);
        String[] lines = outContent.toString().trim().split(System.lineSeparator());
        for (String line : lines) {
            String[] words = line.split(": ");
            assertTrue(expected.containsKey(words[0]));
            assertEquals(expected.get(words[0]).intValue(), Integer.parseInt(words[1]));
        }
    }
}
