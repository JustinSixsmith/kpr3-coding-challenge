import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static final ArrayList<String> TEST_ARRAY = new ArrayList<>(Arrays.asList("this is a", "is a test"));
    public static final String SIMPLE_TEXT_FILE = "src/main/resources/texts/simple.txt";
    public static final String TWO_WORD_FILE = "src/main/resources/texts/2-word-catcher.txt";
    public static final String[] TEST_ARGS = {SIMPLE_TEXT_FILE, TWO_WORD_FILE};
    public static final List<File> TEST_FILES = new ArrayList<>();

    @Before
    public void setUp() {
    }

    @Test
    void createAFileArrayTest() {
        TEST_FILES.add(new File(SIMPLE_TEXT_FILE));
        TEST_FILES.add(new File(TWO_WORD_FILE));
        assertEquals(TEST_FILES, Solution.addFilePaths(TEST_ARGS));
    }

    @Test
    void makeAStringFromATextFileTest() {
        String simpleString = "This is a test.";
        assertEquals(TEST_ARRAY, Solution.createPhraseArray(simpleString));
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