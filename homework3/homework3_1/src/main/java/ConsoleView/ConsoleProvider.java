package ConsoleView;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleProvider {
    private final Scanner keyboard = new Scanner(System.in);

    public void print(Object o) {
        System.out.print(o);
    }

    /**
     * A wrapper of {@code System.out.println(Object o)}
     *
     * @param o the object to print
     */
    public void println(Object o) {
        System.out.println(o);
    }

    /**
     * A wrapper of {@code System.out.println()}
     */
    public void println() {
        System.out.println();
    }

    public <T> T prompt(String message, Class<T> expectedClass, Validator<T> validator) {
        boolean isValid = false;
        Object input = null;
        T output = null;
        this.print(message);
        while (!isValid) {
            try {
                if (expectedClass == Integer.class) {
                    input = keyboard.nextInt();
                } else if (expectedClass == Double.class) {
                    input = keyboard.nextDouble();
                } else if (expectedClass == String.class) {
                    input = keyboard.nextLine();
                } else if (expectedClass == Byte.class) {
                    input = keyboard.nextByte();
                } else if (expectedClass == BigDecimal.class) {
                    input = keyboard.nextBigDecimal();
                } else if (expectedClass == BigInteger.class) {
                    input = keyboard.nextBigInteger();
                } else if (expectedClass == Boolean.class) {
                    input = keyboard.nextBoolean();
                } else if (expectedClass == Float.class) {
                    input = keyboard.nextFloat();
                } else if (expectedClass == Long.class) {
                    input = keyboard.nextLong();
                } else if (expectedClass == Short.class) {
                    input = keyboard.nextShort();
                }

                output = expectedClass.cast(input);
                isValid = validator == null || validator.isValid(output);
            } catch (InputMismatchException e) {
                // nothing
            } finally {
                if (expectedClass != String.class) {
                    keyboard.nextLine();
                }
                if(!isValid){
                    this.print(UIResources.INPUT_ERROR_MESSAGE);
                }
            }
        }
        return output;
    }

    public  <T> T prompt(String message, Class<T> expectedClass) {
        return this.prompt(message, expectedClass, null);
    }
}
