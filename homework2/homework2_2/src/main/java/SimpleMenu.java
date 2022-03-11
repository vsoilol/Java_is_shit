import Extensions.ArrayExtension;
import Factorial.FactorialOperations;
import FibonacciSeries.FibonacciSeriesOperations;
import Types.OperationType;

public class SimpleMenu {
    final int OPERATION_TYPE_MAX_VALUE = 2;
    final int LOOP_TYPE_MAX_VALUE = 3;

    private int operationType;
    private int loopType;
    private int number;

    public SimpleMenu(String[] values) throws NumberFormatException, IllegalArgumentException {
        validateValues(values);
    }

    public String invokeOperation() {
        String result = "";

        switch (operationType) {
            case (OperationType.FIBONACCI_SERIES):
                int[] fibonacciSeries = FibonacciSeriesOperations.Operations.get(loopType).getFibonacciNumbers(number);
                result = ArrayExtension.toStringWithComma(fibonacciSeries);
                break;

            case (OperationType.FACTORIAL):
                result = FactorialOperations.Operations.get(loopType).calculateFactorial(number).toString();
                break;
        }

        return result;
    }

    private void validateValues(String[] values) throws NumberFormatException, IllegalArgumentException {
        if (values.length != 3) {
            throw new IllegalArgumentException(ExceptionMessages.VALUES_LENGTH_INCORRECT);
        }

        if (!tryParseValues(values)) {
            throw new NumberFormatException(ExceptionMessages.CANNOT_PARSE_VALUES);
        }

        if (!areValuesValid()) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_VALUES);
        }
    }

    private boolean areValuesValid() {
        if (operationType <= 0 || operationType > OPERATION_TYPE_MAX_VALUE) {
            return false;
        }

        if (loopType <= 0 || loopType > LOOP_TYPE_MAX_VALUE) {
            return false;
        }

        if (number <= 0) {
            return false;
        }

        return true;
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
