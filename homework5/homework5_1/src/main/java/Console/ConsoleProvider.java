package Console;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class ConsoleProvider {
    private final Map<Class, Supplier<Object>> keyboardParseInputs;

    private final Scanner keyboard = new Scanner(System.in);

    public ConsoleProvider() {
        this.keyboardParseInputs = new HashMap<>() {{
            put(Integer.class, keyboard::nextInt);
            put(Double.class, keyboard::nextDouble);
            put(String.class, keyboard::nextLine);
            put(Byte.class, keyboard::nextByte);
            put(BigDecimal.class, keyboard::nextBigDecimal);
            put(BigInteger.class, keyboard::nextBigInteger);
            put(Boolean.class, keyboard::nextBoolean);
            put(Float.class, keyboard::nextFloat);
            put(Long.class, keyboard::nextLong);
            put(Short.class, keyboard::nextShort);
        }};
    }

    public static ConsoleProvider getInstance() {
        return new ConsoleProvider();
    }

    public void print(Object o) {
        System.out.print(o);
    }

    public void println(Object o) {
        System.out.println(o);
    }

    public void println() {
        System.out.println();
    }

    public <T> T prompt(String message, Class<T> expectedClass) {
        Object input = null;
        T output = null;
        this.print(message);

        try {
            input = keyboardParseInputs.get(expectedClass).get();

            output = expectedClass.cast(input);
        } catch (InputMismatchException ignored) {
        } finally {
            if (expectedClass != String.class) {
                keyboard.nextLine();
            }
        }

        return output;
    }
}
