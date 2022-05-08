import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidationSystemTests {
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    public void testValidateInt(int value)  {
        boolean expected = ValidationSystem.validate(value);

        assertTrue(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {11, 0})
    public void testValidateIntFails(int value) {
        boolean expected = ValidationSystem.validate(value);

        assertFalse(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello", "Hello world, abc"})
    public void testValidateString(String value)  {
        boolean expected = ValidationSystem.validate(value);

        assertTrue(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello", ""})
    public void testValidateStringFails(String value) {
        boolean expected = ValidationSystem.validate(value);

        assertFalse(expected);
    }
}
