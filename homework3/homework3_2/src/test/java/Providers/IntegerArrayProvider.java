package Providers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class IntegerArrayProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of(15, new int[]{2, 3, 6, 12, 15, 34, 65, 78, 99}),
                Arguments.of(13.5, new int[]{2, 3, 6, 12, 15, 34, 65, 78})
        );
    }
}
