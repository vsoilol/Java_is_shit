import Extensions.ArrayExtension;

public class SimpleMenu {
    private int operationType;
    private int loopType;
    private int number;

    private final FibonacciSeries fibonacciSeries;
    private final Factorial factorial;

    public SimpleMenu(){
        fibonacciSeries = new FibonacciSeries();
        factorial = new Factorial();
    }

    public String invokeOperation(String[] values) throws NumberFormatException{
        if (!tryParseValues(values)) {
            throw new NumberFormatException("Cannot value parameters");
        }

        String result = "";

        switch (operationType) {
            case (1) -> {
                int[] fibonacciSeries = this.fibonacciSeries.getFibonacciNumbers(loopType, number);
                result = ArrayExtension.toStringWithComma(fibonacciSeries);
            }
            case (2) -> result = factorial.calculateFactorial(loopType, number).toString();
        }

        return result;
    }

    private boolean tryParseValues(String[] values) {
        try {
            operationType = Integer.parseInt(values[0]);
            loopType = Integer.parseInt(values[1]);
            number = Integer.parseInt(values[2]);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
