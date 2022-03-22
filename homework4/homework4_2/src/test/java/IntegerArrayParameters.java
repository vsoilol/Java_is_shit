import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class IntegerArrayParameters implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of(new Integer[]{2, 15, 11, 15, 19, 9, 9, 0, 13, 12, 8, 10, 10, 13, 3, 4, 19, 19, 0, 11},
                            new Integer[]{0, 0, 2, 3, 4, 8, 9, 9, 10, 10, 11, 11, 12, 13, 13, 15, 15, 19, 19, 19}),
                Arguments.of(new Integer[]{29, 10, 10, 1, 32, 27, 9, 41, 14, 36},
                        new Integer[]{1, 9, 10, 10, 14, 27, 29, 32, 36, 41}),
                Arguments.of(new Integer[]{36, 16, 32, 44, 7, 24, 10, 36, 33, 42},
                        new Integer[]{7, 10, 16, 24, 32, 33, 36, 36, 42, 44}),
                Arguments.of(new Integer[]{19, 21, 4, 28, 18, 46, 15, 34, 41, 19},
                        new Integer[]{4, 15, 18, 19, 19, 21, 28, 34, 41, 46}),
                Arguments.of(new Integer[]{35, 30, 27, 18, 26, 44, 25, 32, 19, 11},
                        new Integer[]{11, 18, 19, 25, 26, 27, 30, 32, 35, 44})
        );
    }
}
