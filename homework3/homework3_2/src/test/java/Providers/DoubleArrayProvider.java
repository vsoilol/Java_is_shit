package Providers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class DoubleArrayProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of(4.0, new Double[]{1.2, 3.0, 4.0, 5.0, 8.0}),
                Arguments.of(4.7, new Double[]{1.2, 9.1, 3.0, 4.0, 7.3, 5.4})
        );
    }
}
