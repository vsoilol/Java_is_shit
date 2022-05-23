import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Java7StatisticServiceTests {
    private final Java7StatisticService staticService = new Java7StatisticService();

    @ParameterizedTest
    @MethodSource("countEvenNumbersParameters")
    public void testCountEvenNumbersShouldWorkAsExpected(List<Long> array, long expected) {
        long actual = staticService.countEvenNumbers(array);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("calculateSquareOfDistinctNumbersParameters")
    public void testCalculateSquareOfDistinctNumbersShouldWorkAsExpected(List<Long> array, List<Long> expected) {
        List<Long> actual = staticService.calculateSquareOfDistinctNumbers(array);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("groupStringsByLastLetterParameters")
    public void testGroupStringsByLastLetterShouldWorkAsExpected(Set<List<String>> strings,
                                                                 Map<Character, List<String>> expected) {
        Map<Character, List<String>> actual = staticService.groupStringsByLastLetter(strings);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> groupStringsByLastLetterParameters() {
        return Stream.of(
                Arguments.of(Set.of(List.of("asfsd", "", "dfsdf"), List.of("asfsda", "sffd")),
                        Map.of('D', List.of("asfsd", "sffd"),
                                'F', List.of("dfsdf"),
                                'A', List.of("asfsda")))
        );
    }

    private static Stream<Arguments> calculateSquareOfDistinctNumbersParameters() {
        return Stream.of(
                Arguments.of(List.of(1L, 2L, 3L, 4L, 5L, 6L), List.of(1L, 4L, 9L, 16L, 25L, 36L)),
                Arguments.of(List.of(6L, 5L, 1L, 3L, 2L, 4L), List.of(1L, 4L, 9L, 16L, 25L, 36L))
        );
    }

    private static Stream<Arguments> countEvenNumbersParameters() {
        return Stream.of(
                Arguments.of(List.of(1L, 2L, 3L, 4L, 5L, 6L), 3L),
                Arguments.of(List.of(1L, 3L, 5L), 0L),
                Arguments.of(List.of(), 0L)
        );
    }
}
