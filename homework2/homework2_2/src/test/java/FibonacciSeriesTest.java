import FibonacciSeries.FibonacciSeriesWithDoWhile;
import FibonacciSeries.FibonacciSeriesWithFor;
import FibonacciSeries.FibonacciSeriesWithWhile;
import Providers.FibonacciSeriesProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FibonacciSeriesTest {

    @ParameterizedTest
    @ArgumentsSource(FibonacciSeriesProvider.class)
    public void testGetFibonacciNumbersWithWhileShouldWorkAsExpected(int numbersAmount, int[] expected) {
        int[] actual = (new FibonacciSeriesWithWhile()).getFibonacciNumbers(numbersAmount);
        assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @ArgumentsSource(FibonacciSeriesProvider.class)
    public void testGetFibonacciNumbersWithDoWhileShouldWorkAsExpected(int numbersAmount, int[] expected) {
        int[] actual = (new FibonacciSeriesWithDoWhile()).getFibonacciNumbers(numbersAmount);
        assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @ArgumentsSource(FibonacciSeriesProvider.class)
    public void testGetFibonacciNumbersWithForShouldWorkAsExpected(int numbersAmount, int[] expected) {
        int[] actual = (new FibonacciSeriesWithFor()).getFibonacciNumbers(numbersAmount);
        assertArrayEquals(expected, actual);
    }
}
