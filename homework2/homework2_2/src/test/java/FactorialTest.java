import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {
    private Factorial factorial;

    @BeforeEach
    public void init() {
        factorial = new Factorial();
    }

    @ParameterizedTest
    @MethodSource("factorialProvider")
    public void testCalculateFactorialWithWhileShouldWorkAsExpected(int number, Long expected) {
        Long actual = factorial.calculateFactorial(LoopType.WHILE, number);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("factorialProvider")
    public void testCalculateFactorialWithDoWhileShouldWorkAsExpected(int number, Long expected) {
        Long actual = factorial.calculateFactorial(LoopType.DO_WHILE, number);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("factorialProvider")
    public void testCalculateFactorialWithForShouldWorkAsExpected(int number, Long expected) {
        Long actual = factorial.calculateFactorial(LoopType.FOR, number);
        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateFactorialShouldThrowExceptionWhenLoopTypeIsNotCorrect() {
        assertThrows(IllegalArgumentException.class,
                () -> factorial.calculateFactorial(4, 1));
    }

    static Stream<Arguments> factorialProvider() {
        return Stream.of(
                Arguments.of(1, 1l),
                Arguments.of(2, 2l),
                Arguments.of(3, 6l),
                Arguments.of(9, 362880l),
                Arguments.of(10, 3628800l),
                Arguments.of(15, 1307674368000l)
        );
    }
}
