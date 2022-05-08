import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianTest {
    @ParameterizedTest
    @MethodSource("integerArrayProvider")
    public void testMedianWithIntegerArrayShouldWorkAsExpected(double expected, int[] values) {
        Double actual = Median.median(values);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("doubleArrayProvider")
    public void testMedianWithDoubleArrayShouldWorkAsExpected(double expected, Double[] values) {
        Double actual = Median.median(values);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> integerArrayProvider() {
        return Stream.of(
                Arguments.of(15, new int[]{2, 3, 6, 12, 15, 34, 65, 78, 99}),
                Arguments.of(13.5, new int[]{2, 3, 6, 12, 15, 34, 65, 78})
        );
    }

    static Stream<Arguments> doubleArrayProvider() {
        return Stream.of(
                Arguments.of(4.0, new Double[]{1.2, 3.0, 4.0, 5.0, 8.0}),
                Arguments.of(4.7, new Double[]{1.2, 9.1, 3.0, 4.0, 7.3, 5.4})
        );
    }
}
