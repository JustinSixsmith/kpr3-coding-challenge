package main;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static main.Sequence.createPhraseArray;

public class SequenceTest {

    @Test
    public void testCreatePhraseArray() {
        assertEquals("Hellothere", createPhraseArray("Hello there"));
    }


}
