package LetterInfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LetterInfoServiceTests {
    private LetterInfoService service;

    @BeforeEach
    public void init() {
        service = new LetterInfoService();
    }

    @Test
    void testCreateLettersInfoByTextShouldWorkAsExpected() {
        String text = "Time Once a,";

        ArrayList<LetterInfo> result = service.createLettersInfoByText(text);

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals('a', result.get(0).getLetter());
        assertEquals('o', result.get(1).getLetter());
        assertEquals('t', result.get(2).getLetter());
    }

    @Test
    void testCreateLettersInfoByTextShouldIncreaseOneWord() {
        String text = "Time Once a, time";

        ArrayList<LetterInfo> result = service.createLettersInfoByText(text);
        Integer wordAmount = result.get(2).getWords().get("time");

        assertEquals(2, wordAmount);
    }

    @Test
    void testGetLettersInfoViewShouldWorkAsExpectedWithOneLetterInfo() {
        ArrayList<LetterInfo> lettersInfo = new ArrayList<LetterInfo>() {{
            add(new LetterInfo("aaa", 3));
        }};
        String expected = "A:\taaa 3\n\n";

        String actual = service.getLettersInfoView(lettersInfo);
        assertEquals(expected, actual);
    }

    @Test
    void testGetLettersInfoViewShouldWorkAsExpectedWithOneLetterInfoAndTwoWord() {
        ArrayList<LetterInfo> lettersInfo = new ArrayList<LetterInfo>() {{
            add(new LetterInfo("aaa", 3));
        }};
        lettersInfo.get(0).putWord("abc", 1);
        String expected = "A:\taaa 3\n\tabc 1\n\n";

        String actual = service.getLettersInfoView(lettersInfo);
        assertEquals(expected, actual);
    }

    @Test
    void testGetLettersInfoViewShouldWorkAsExpectedWithManyLettersInfoAndManyWords() {
        ArrayList<LetterInfo> lettersInfo = new ArrayList<LetterInfo>() {{
            add(new LetterInfo("abc", 3));
            add(new LetterInfo("cab", 1));
            add(new LetterInfo("bca", 2));
        }};
        lettersInfo.get(0).putWord("aaa", 1);
        lettersInfo.get(1).putWord("ccc", 1);
        lettersInfo.get(1).putWord("cccjh", 1);
        String expected = "A:\taaa 1\n\tabc 3\n\nB:\tbca 2\n\nC:\tcccjh 1\n\tccc 1\n\tcab 1\n\n";

        String actual = service.getLettersInfoView(lettersInfo);
        assertEquals(expected, actual);
    }
}
