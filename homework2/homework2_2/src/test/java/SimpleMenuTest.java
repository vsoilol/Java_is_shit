import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleMenuTest {
    private final String[] VALID_VALUES = new String[]{"1", "2", "7"};

    private SimpleMenu simpleMenu;

    @BeforeEach
    public void init() {
        simpleMenu = new SimpleMenu();
    }

    @Test
    public void testInvokeOperationShouldWorkAsExpected() {
        String expected = simpleMenu.invokeOperation(VALID_VALUES);

        assertNotEquals(0, expected.length());
    }

    @ParameterizedTest
    @MethodSource("incorrectValuesProvider")
    public void testInvokeOperationShouldThrowNumberFormatException(String[] values) {
        assertThrows(NumberFormatException.class, () -> simpleMenu.invokeOperation(values));
    }

    @Test
    public void testInvokeOperationShouldNotThrowIllegalArgumentOrNumberFormatException() {
        assertDoesNotThrow(() -> simpleMenu.invokeOperation(VALID_VALUES));
    }

    static Stream<Arguments> incorrectValuesProvider() {
        return Stream.of(
                (Object) new String[]{"2", "k", "3"},
                (Object) new String[]{"2", "1.1", "3"},
                (Object) new String[]{"a", "2", "4"}).map(Arguments::of);
    }
}
