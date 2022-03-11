package FibonacciSeries;

public class FibonacciSeriesWithDoWhile implements FibonacciSeries {

    public int[] getFibonacciNumbers(int numbersAmount) {
        int[] result = new int[numbersAmount];

        int prevVal = 1;
        int prevPrevVal = 0;
        int i = 0;

        do {
            result[i] = prevPrevVal;

            int currVal = prevVal + prevPrevVal;
            prevPrevVal = prevVal;
            prevVal = currVal;

            i++;
        } while (i < numbersAmount);

        return result;
    }
}
