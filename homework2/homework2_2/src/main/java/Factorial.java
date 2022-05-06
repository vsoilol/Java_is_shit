public class Factorial {
    public Long calculateFactorial(int loopType, int number){
        Long result;

        switch (loopType) {
            case (LoopType.WHILE) -> result = calculateFactorialWithWhile(number);
            case (LoopType.DO_WHILE) -> result = calculateFactorialWithDoWhile(number);
            case (LoopType.FOR) -> result = calculateFactorialWithFor(number);
            default -> throw new IllegalArgumentException("Loop type is not correct");
        }

        return result;
    }

    private Long calculateFactorialWithDoWhile(int number) {
        long factorial = 1;
        int i = 1;

        do {
            factorial = factorial * i;
            i++;
        } while (i <= number);

        return factorial;
    }

    private Long calculateFactorialWithFor(int number) {
        long factorial = 1;

        for (int i = 1; i <= number; i++) {
            factorial = factorial * i;
        }

        return factorial;
    }

    private Long calculateFactorialWithWhile(int number) {
        long factorial = 1;
        int i = 1;

        while (i <= number) {
            factorial = factorial * i;
            i++;
        }

        return factorial;
    }
}
