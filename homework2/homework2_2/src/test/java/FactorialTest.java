import Factorial.FactorialWithDoWhile;
import Factorial.FactorialWithWhile;
import Providers.FactorialProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest {
    @ParameterizedTest
    @ArgumentsSource(FactorialProvider.class)
    public void testCalculateFactorialWithWhileShouldWorkAsExpected(int number, Long expected) {
        Long actual = (new FactorialWithWhile()).calculateFactorial(number);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ArgumentsSource(FactorialProvider.class)
    public void testCalculateFactorialWithForShouldWorkAsExpected(int number, Long expected) {
        Long actual = (new FactorialWithWhile()).calculateFactorial(number);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ArgumentsSource(FactorialProvider.class)
    public void testCalculateFactorialWithDoWhileShouldWorkAsExpected(int number, Long expected) {
        Long actual = (new FactorialWithDoWhile()).calculateFactorial(number);
        assertEquals(expected, actual);
    }
}
