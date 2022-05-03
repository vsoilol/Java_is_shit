import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BubbleSortTests {
    private BubbleSort bubbleSort;

    @BeforeEach
    public void init() {
        this.bubbleSort = new BubbleSort();
    }

    @ParameterizedTest
    @ArgumentsSource(IntegerArrayParameters.class)
    public void testSortShouldWorkAsExpected(Integer[] unsorted, Integer[] sorted) {
        bubbleSort.sort(unsorted);
        assertArrayEquals(sorted, unsorted);
    }
}
