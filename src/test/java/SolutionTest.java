import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static final ArrayList<String> TEST_ARRAY = new ArrayList<>(Arrays.asList("this is a", "is a test"));
    public static final String SIMPLE_TEXT_PATH = "src/main/resources/texts/simple.txt";
    public static final String TWO_WORD_PATH = "src/main/resources/texts/2-word-catcher.txt";
    public static final String[] SINGLE_TEST_ARGS = {SIMPLE_TEXT_PATH};
    public static final String[] TEST_ARGS = {SIMPLE_TEXT_PATH, TWO_WORD_PATH};
    public static final List<File> SINGLE_TEST_FILE = new ArrayList<>();
    public static final List<File> TEST_FILES = new ArrayList<>();

    @Before
    public void setUp() {
    }

    @Test
    void createASingleFileListTest() {
        SINGLE_TEST_FILE.add(new File(SIMPLE_TEXT_PATH));
        assertEquals(SINGLE_TEST_FILE, Solution.addFilePaths(SINGLE_TEST_ARGS));
    }

    @Test
    void createAMultipleFilesListTest() {
        TEST_FILES.add(new File(SIMPLE_TEXT_PATH));
        TEST_FILES.add(new File(TWO_WORD_PATH));
        assertEquals(TEST_FILES, Solution.addFilePaths(TEST_ARGS));
    }

    @Test
    void countPhrases() {
    }
}