import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SelectionSortTests {
    private SelectionSort selectionSort;

    @BeforeEach
    public void init() {
        this.selectionSort = new SelectionSort();
    }

    @ParameterizedTest
    @ArgumentsSource(IntegerArrayParameters.class)
    public void testSortShouldWorkAsExpected(Integer[] unsorted, Integer[] sorted) {
        selectionSort.sort(unsorted);
        assertArrayEquals(sorted, unsorted);
    }
}
