package Extensions;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayExtension {

    public static String toStringWithComma(int[] array) {
        return Arrays.stream(array)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
