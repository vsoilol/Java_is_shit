package FibonacciSeries;

public class FibonacciSeriesWithWhile implements FibonacciSeries {

    public int[] getFibonacciNumbers(int numbersAmount) {
        int[] result = new int[numbersAmount];

        int i = 1;
        int prevVal = 1;
        int prevPrevVal = 0;

        while (i <= numbersAmount) {
            result[i - 1] = prevPrevVal;

            int currVal = prevVal + prevPrevVal;
            prevVal = prevPrevVal;
            prevPrevVal = currVal;

            i++;
        }

        return result;
    }
}
