import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntegerArrayComparatorTests {
    private final IntegerSumDigitsComparator comparator = new IntegerSumDigitsComparator();

    @Test
    public void testEqual() {
        Integer firstNumber = 12;
        Integer secondNumber = 21;
        int result = comparator.compare(firstNumber, secondNumber);
        assertEquals(0, result);
    }

    @Test
    public void testGreaterThan() {
        Integer firstNumber = 22;
        Integer secondNumber = 100;
        int result = comparator.compare(firstNumber, secondNumber);
        assertTrue(result >= 1);
    }

    @Test
    public void testLessThan() {
        Integer firstNumber = 200;
        Integer secondNumber = 22;
        int result = comparator.compare(firstNumber, secondNumber);
        assertTrue(result <= -1);
    }
}
