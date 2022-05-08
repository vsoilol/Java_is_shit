import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Supplier;

public class Console {
    private final Map<Class, Supplier<Object>> keyboardParseInputs;

    private final Scanner keyboard = new Scanner(System.in);

    public Console() {
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

    public void write(Object o) {
        System.out.print(o);
    }

    public void writeLine(Object o) {
        System.out.println(o);
    }

    public void writeLine() {
        System.out.println();
    }

    public <T> T readLine(String message, Class<T> expectedClass) {
        Object input = null;
        T output = null;
        this.write(message);

        try {
            input = keyboardParseInputs.get(expectedClass).get();

            output = expectedClass.cast(input);
        } catch (InputMismatchException ignored) {
            writeLine("Input error!!!");
        } finally {
            if (expectedClass != String.class) {
                keyboard.nextLine();
            }
        }

        return output;
    }
}
