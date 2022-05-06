public class FibonacciSeries {
    public int[] getFibonacciNumbers(int loopType, int numbersAmount) {
        int[] result;

        switch (loopType) {
            case (LoopType.WHILE) -> result = getFibonacciNumbersWithWhile(numbersAmount);
            case (LoopType.DO_WHILE) -> result = getFibonacciNumbersWithDoWhile(numbersAmount);
            case (LoopType.FOR) -> result = getFibonacciNumbersWithFor(numbersAmount);
            default -> throw new IllegalArgumentException("Loop type is not correct");
        }

        return result;
    }

    private int[] getFibonacciNumbersWithDoWhile(int numbersAmount) {
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

    private int[] getFibonacciNumbersWithFor(int numbersAmount) {
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

    private int[] getFibonacciNumbersWithWhile(int numbersAmount) {
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
