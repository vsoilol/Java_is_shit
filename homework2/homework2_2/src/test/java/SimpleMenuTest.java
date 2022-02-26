import Providers.IncorrectValues;
import Providers.InvalidValues;
import Providers.ValuesWithIncorrectLength;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleMenuTest {
    private final String[] VALID_VALUES = new String[]{"1", "2", "7"};

    @Test
    public void testInvokeOperationShouldWorkAsExpected() {
        SimpleMenu menu = new SimpleMenu(VALID_VALUES);

        String expected = menu.invokeOperation();

        assertNotEquals(0, expected.length());
    }

    @ParameterizedTest
    @ArgumentsSource(InvalidValues.class)
    public void testConstructorShouldThrowIllegalArgumentExceptionWhenValuesInvalid(String[] values) {
        assertThrows(IllegalArgumentException.class, () -> new SimpleMenu(values));
    }

    @ParameterizedTest
    @ArgumentsSource(ValuesWithIncorrectLength.class)
    public void testConstructorShouldThrowIllegalArgumentExceptionWhenLengthNotEqualThree(String[] values) {
        assertThrows(IllegalArgumentException.class, () -> new SimpleMenu(values));
    }

    @ParameterizedTest
    @ArgumentsSource(IncorrectValues.class)
    public void testConstructorShouldThrowNumberFormatException(String[] values) {
        assertThrows(NumberFormatException.class, () -> new SimpleMenu(values));
    }

    @Test
    public void testConstructorShouldNotThrowIllegalArgumentOrNumberFormatException() {
        assertDoesNotThrow(() -> new SimpleMenu(VALID_VALUES));
    }
}
