package LetterInfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LetterInfoTests {
    private LetterInfo letterInfo;

    private final String word = "aaaa";
    private final Character letter = word.charAt(0);

    @BeforeEach
    public void init() {
        letterInfo = new LetterInfo(word, 1);
    }

    @Test
    public void testPutWordShouldPutNewWord() {
        String newWord = "boy";

        letterInfo.putWord(newWord, 1);
        Map<String, Integer> words = letterInfo.getWords();

        assertEquals(2, words.size());
        assertTrue(words.containsKey(newWord));
    }

    @Test
    public void testGetLetterShouldWorkAsExpected() {
        Character actual = letterInfo.getLetter();

        assertEquals(letter, actual);
    }

    @Test
    public void testGetWordsShouldWorkAsExpected() {
        Map<String, Integer> words = letterInfo.getWords();

        assertNotNull(words);
        assertEquals(1, words.size());
    }

    @Test
    void testCompareToShouldWorkAsExpected() {
        LetterInfo letterB = new LetterInfo("bojds", 1);

        assertEquals(-1, letterInfo.compareTo(letterB));

        LetterInfo letterA = new LetterInfo("addfsd", 1);

        assertEquals(0, letterInfo.compareTo(letterA));

        assertEquals(1, letterB.compareTo(letterInfo));
    }
}
