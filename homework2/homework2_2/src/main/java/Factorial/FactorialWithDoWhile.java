package Factorial;

public class FactorialWithDoWhile implements Factorial {

    public Long calculateFactorial(int number) {
        long factorial = 1;
        int i = 1;

        do {
            factorial = factorial * i;
            i++;
        } while (i <= number);

        return factorial;
    }
}
