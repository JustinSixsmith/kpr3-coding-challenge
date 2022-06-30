import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static final ArrayList<String> TEST_ARRAY = new ArrayList<>(Arrays.asList("this is a", "is a test"));
    public static final String[] SAMPLE_TEXT_FILE = {"src/main/resources/texts/sample.txt", "src/main/resources/texts/sample.txt"};

    @Test
    void main() {
    }

    @Test
    void makeLowerCaseTest() {
        String testString = "THIS IS A TEST";
        assertEquals(TEST_ARRAY, Solution.createPhraseArray(testString));
    }

    @Test
    void removePunctuationTest() {
        String testString = "Th!is. is&* a Test#@";
        assertEquals(TEST_ARRAY, Solution.createPhraseArray(testString));
    }

    @Test
    void countPhrases() {
    }
}