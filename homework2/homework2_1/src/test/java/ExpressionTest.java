import Providers.IncorrectParameters;
import Providers.InvalidParameters;
import Providers.ParametersWithIncorrectLength;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionTest {

    private final String[] VALID_PARAMETERS = new String[]{"3", "2", "4.3", "5.3"};

    @Test
    public void testCalculateShouldNotThrowIllegalArgumentException() {
        Expression expression = new Expression(VALID_PARAMETERS);
        assertDoesNotThrow(expression::calculate);
    }

    @ParameterizedTest
    @ArgumentsSource(InvalidParameters.class)
    public void testCalculateShouldThrowIllegalArgumentException(String[] parameters) {
        Expression expression = new Expression(parameters);
        assertThrows(IllegalArgumentException.class, expression::calculate);
    }

    @ParameterizedTest
    @ArgumentsSource(ParametersWithIncorrectLength.class)
    public void testConstructorShouldThrowIllegalArgumentException(String[] parameters) {
        assertThrows(IllegalArgumentException.class, () -> new Expression(parameters));
    }

    @ParameterizedTest
    @ArgumentsSource(IncorrectParameters.class)
    public void testConstructorShouldThrowNumberFormatException(String[] parameters) {
        assertThrows(NumberFormatException.class, () -> new Expression(parameters));
    }

    @Test
    public void testConstructorShouldNotThrowIllegalArgumentOrNumberFormatException() {
        assertDoesNotThrow(() -> new Expression(VALID_PARAMETERS));
    }
}
