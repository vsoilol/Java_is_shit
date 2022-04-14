package Validators;

import LetterInfo.LetterInfo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LetterInfoViewValidatorTests {
    private final LetterInfoViewValidator validator = new LetterInfoViewValidator();

    @Test
    public void testCheckLettersInfoShouldNotThrowIllegalArgumentException() {
        ArrayList<LetterInfo> lettersInfo = new ArrayList<>(){
            {
                add(new LetterInfo("aaaaaa"));
            }
        };

       assertDoesNotThrow(() -> validator.check(lettersInfo));
    }

    @Test
    public void testCheckLettersInfoShouldThrowIllegalArgumentException() {
        ArrayList<LetterInfo> lettersInfo = new ArrayList<>();

        assertThrows(IllegalArgumentException.class, () -> validator.check(lettersInfo));
    }
}
