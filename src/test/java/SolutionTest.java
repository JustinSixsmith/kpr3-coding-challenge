import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static final ArrayList<String> TEST_ARRAY = new ArrayList<>(Arrays.asList("this is a", "is a test"));
    @Test
    void main() {
    }

    @Test
    void createPhraseArray() {
        String testString = "This is a test.";
        assertEquals(TEST_ARRAY, Solution.createPhraseArray(testString));
    }

    @Test
    void countPhrases() {
    }
}