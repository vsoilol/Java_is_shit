package LetterInfo;

import Validators.LetterInfoBuilderValidator;
import Validators.LetterInfoViewValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

public class LetterInfoViewTests {
    private LetterInfoView view;

    @BeforeEach
    public void init() {
        LetterInfoViewValidator validator = mock(LetterInfoViewValidator.class);
        doNothing().when(validator).check(isA(ArrayList.class));

        view = new LetterInfoView(validator);
    }

    @Test
    void testGetLettersInfoViewShouldWorkAsExpectedWithOneLetterInfo() {
        ArrayList<LetterInfo> lettersInfo = new ArrayList<LetterInfo>(){{
            add(new LetterInfo("aaa", 3));
        }};
        String expected = "A:\taaa 3\n\n";

        String actual = view.getLettersInfoView(lettersInfo);
        assertEquals(expected, actual);
    }

    @Test
    void testGetLettersInfoViewShouldWorkAsExpectedWithOneLetterInfoAndTwoWord() {
        ArrayList<LetterInfo> lettersInfo = new ArrayList<LetterInfo>(){{
            add(new LetterInfo("aaa", 3));
        }};
        lettersInfo.get(0).putWord("abc");
        String expected = "A:\taaa 3\n\tabc 1\n\n";

        String actual = view.getLettersInfoView(lettersInfo);
        assertEquals(expected, actual);
    }

    @Test
    void testGetLettersInfoViewShouldWorkAsExpectedWithManyLettersInfoAndManyWords() {
        ArrayList<LetterInfo> lettersInfo = new ArrayList<LetterInfo>(){{
            add(new LetterInfo("abc", 3));
            add(new LetterInfo("cab", 1));
            add(new LetterInfo("bca", 2));
        }};
        lettersInfo.get(0).putWord("aaa");
        lettersInfo.get(1).putWord("ccc");
        lettersInfo.get(1).putWord("cccjh");
        String expected = "A:\taaa 1\n\tabc 3\n\nB:\tbca 2\n\nC:\tcccjh 1\n\tccc 1\n\tcab 1\n\n";

        String actual = view.getLettersInfoView(lettersInfo);
        assertEquals(expected, actual);
    }
}
