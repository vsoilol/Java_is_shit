package Validators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ExchangeRateValidatorTest {
    private ExchangeRateValidator validator;

    @BeforeEach
    public void init() {
        this.validator = new ExchangeRateValidator();
    }

    @Test
    public void testIsValidShouldReturnTrue() {
        boolean actual = validator.isValid(BigDecimal.valueOf(10));

        assertTrue(actual);
    }

    @Test
    public void testIsValidShouldReturnFalse() {
        boolean actual = validator.isValid(BigDecimal.valueOf(-10));

        assertFalse(actual);
    }
}
