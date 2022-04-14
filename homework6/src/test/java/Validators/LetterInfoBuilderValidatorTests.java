package Validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LetterInfoBuilderValidatorTests {
    private final LetterInfoBuilderValidator validator = new LetterInfoBuilderValidator();

    @Test
    public void testCheckTextShouldNotThrowIllegalArgumentException() {
        String text = "dsfsdf";

        assertDoesNotThrow(() -> validator.check(text));
    }

    @Test
    public void testCheckTextShouldThrowIllegalArgumentException() {
        String text = "";

        assertThrows(IllegalArgumentException.class, () -> validator.check(text));
    }
}
