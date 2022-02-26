package FibonacciSeries;

public class FibonacciSeriesWithFor implements FibonacciSeries {

    public int[] getFibonacciNumbers(int numbersAmount) {
        int[] result = new int[numbersAmount];

        int prevVal = 1;
        int prevPrevVal = 0;

        for (int i = 1; i <= numbersAmount; ++i) {
            result[i - 1] = prevPrevVal;

            int currVal = prevVal + prevPrevVal;
            prevVal = prevPrevVal;
            prevPrevVal = currVal;
        }

        return result;
    }
}
