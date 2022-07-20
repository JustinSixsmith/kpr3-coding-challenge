import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static final LinkedList<String> TEST_ARRAY = new LinkedList<>(Arrays.asList("this is a", "is a test"));
    public static final String SIMPLE_TEXT_PATH = "src/main/resources/texts/simple.txt";
    public static final String TWO_WORD_PATH = "src/main/resources/texts/2-word-catcher.txt";
    public static final String[] SINGLE_TEST_ARGS = {SIMPLE_TEXT_PATH};
    public static final String[] MULTI_TEST_ARGS = {SIMPLE_TEXT_PATH, TWO_WORD_PATH};
    public static final List<File> SINGLE_TEST_FILE = new ArrayList<>();
    public static final List<File> MULTI_TEST_FILES = new ArrayList<>();

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
        MULTI_TEST_FILES.add(new File(SIMPLE_TEXT_PATH));
        MULTI_TEST_FILES.add(new File(TWO_WORD_PATH));
        assertEquals(MULTI_TEST_FILES, Solution.addFilePaths(MULTI_TEST_ARGS));
    }

    @Test
    void asserThrowsFileNotFoundTest() {

    }

//    @Test
//    void removePunctuationTest() {
//        String sampleString = "T@^his is$^ a test!";
//        String[] expected = {"this", "is", "a", "test"};
//        assertEquals(expected, Solution.separateWords(sampleString));
//    }

//    @Test
//    void makeLowerCaseTest() {
//        String sampleString = "THIS IS A TEST";
//        String[] expected = {"this", "is", "a", "test"};
//        assertEquals(expected, Solution.separateWords(sampleString));
//    }

    @Test
    void removeBeginningQuoteTest() {
        String expected = "can't";
        assertEquals(expected, Solution.removeSingleQuotes("'can't"));
    }

    @Test
    void removeEndingQuoteTest() {
        String expected = "can't";
        assertEquals(expected, Solution.removeSingleQuotes("can't'"));
    }

    @Test
    void removeBothBeginningAndEndingQuotesTest() {
        String expected = "can't";
        assertEquals(expected, Solution.removeSingleQuotes("'can't'"));
    }

//    @Test
//    void countPhrases() {
//
//        assertEquals(expected, Solution.countPhrases(TEST_ARRAY));
//    }
}