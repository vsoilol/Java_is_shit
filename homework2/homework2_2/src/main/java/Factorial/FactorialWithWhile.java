package Factorial;

public class FactorialWithWhile implements Factorial {

    public Long calculateFactorial(int number) {
        long factorial = 1;
        int i = 1;

        while (i <= number) {
            factorial = factorial * i;
            i++;
        }

        return factorial;
    }
}
