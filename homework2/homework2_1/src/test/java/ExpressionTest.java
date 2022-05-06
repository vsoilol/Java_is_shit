import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionTest {

    private final String[] VALID_PARAMETERS = new String[]{"3", "2", "4.3", "5.3"};
    private Expression expression;

    @BeforeEach
    public void init() {
        expression = new Expression();
    }

    @Test
    public void testCalculateShouldNotThrowNumberFormatException() {
        assertDoesNotThrow(() -> expression.calculate(VALID_PARAMETERS));
    }

    @ParameterizedTest
    @MethodSource("stringArrayProvider")
    public void testCalculateShouldThrowNumberFormatException(String[] parameters) {
        assertThrows(NumberFormatException.class, () -> expression.calculate(parameters));
    }

    static Stream<Arguments> stringArrayProvider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"n", "2", "4.3", "7.1"}),
                Arguments.of((Object) new String[]{"7", "4.1", "4.3", "7.1"}),
                Arguments.of((Object) new String[]{"7.2", "20", "4.3", "7.1"}),
                Arguments.of((Object) new String[]{"7", "l", "3.4", "7.1"})
        );
    }
}
