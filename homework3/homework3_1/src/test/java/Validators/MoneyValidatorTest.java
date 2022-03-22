package Validators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoneyValidatorTest {
    private MoneyValidator validator;

    @BeforeEach
    public void init() {
        this.validator = new MoneyValidator();
    }

    @Test
    public void testIsValidShouldReturnTrue() {
        boolean actual = validator.isValid(10.0);

        assertTrue(actual);
    }

    @Test
    public void testIsValidShouldReturnFalse() {
        boolean actual = validator.isValid(-10.0);

        assertFalse(actual);
    }
}
