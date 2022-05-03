package LetterInfo;

import Validators.LetterInfoBuilderValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

public class LetterInfoBuilderTests {
    private LetterInfoBuilder builder;

    @BeforeEach
    public void init() {
        LetterInfoBuilderValidator validator = mock(LetterInfoBuilderValidator.class);
        doNothing().when(validator).check(isA(String.class));

        builder = new LetterInfoBuilder(validator);
    }

    @Test
    void testCreateLettersInfoByTextShouldWorkAsExpected() {
        String text = "Time Once #$  432!@#$%^&* a,";

        ArrayList<LetterInfo> result = builder.createLettersInfoByText(text);

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals('t', result.get(0).getLetter());
        assertEquals('o', result.get(1).getLetter());
        assertEquals('a', result.get(2).getLetter());
    }

    @Test
    void testCreateLettersInfoByTextShouldIncreaseOneWord() {
        String text = "Time Once #$  432!@#$%^&* a, time111";

        ArrayList<LetterInfo> result = builder.createLettersInfoByText(text);
        Integer wordAmount = result.get(0).getWords().get("time");

        assertEquals(2, wordAmount);
    }
}
