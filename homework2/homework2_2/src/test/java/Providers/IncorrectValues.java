package Providers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class IncorrectValues implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                (Object) new String[]{"2", "k", "3"},
                (Object) new String[]{"2", "1.1", "3"},
                (Object) new String[]{"a", "2", "4"}).map(Arguments::of);
    }
}
