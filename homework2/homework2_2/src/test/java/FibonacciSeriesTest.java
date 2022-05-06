import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FibonacciSeriesTest {

    private FibonacciSeries fibonacciSeries;

    @BeforeEach
    public void init() {
        fibonacciSeries = new FibonacciSeries();
    }

    @ParameterizedTest
    @MethodSource("fibonacciSeriesProvider")
    public void testGetFibonacciNumbersWithWhileShouldWorkAsExpected(int numbersAmount, int[] expected) {
        int[] actual = fibonacciSeries.getFibonacciNumbers(LoopType.WHILE, numbersAmount);
        assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("fibonacciSeriesProvider")
    public void testGetFibonacciNumbersWithDoWhileShouldWorkAsExpected(int numbersAmount, int[] expected) {
        int[] actual = fibonacciSeries.getFibonacciNumbers(LoopType.DO_WHILE, numbersAmount);
        assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("fibonacciSeriesProvider")
    public void testGetFibonacciNumbersWithForShouldWorkAsExpected(int numbersAmount, int[] expected) {
        int[] actual = fibonacciSeries.getFibonacciNumbers(LoopType.FOR, numbersAmount);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetFibonacciNumbersWithForShouldThrowExceptionWhenLoopTypeIsNotCorrect() {
        assertThrows(IllegalArgumentException.class,
                () -> fibonacciSeries.getFibonacciNumbers(4, 1));
    }

    static Stream<Arguments> fibonacciSeriesProvider() {
        return Stream.of(
                Arguments.of(1, new int[]{0}),
                Arguments.of(2, new int[]{0, 1}),
                Arguments.of(7, new int[]{0, 1, 1, 2, 3, 5, 8}),
                Arguments.of(10, new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34}),
                Arguments.of(15, new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377})
        );
    }
}
