package Providers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class FactorialProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of(1, 1l),
                Arguments.of(2, 2l),
                Arguments.of(3, 6l),
                Arguments.of(9, 362880l),
                Arguments.of(10, 3628800l),
                Arguments.of(15, 1307674368000l)
        );
    }
}