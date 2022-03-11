package Providers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class IncorrectParameters implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                (Object) new String[]{"3", "k", "4.6", "7.1"},
                (Object) new String[]{"3", "4.1", "4.3", "5.3"},
                (Object) new String[]{"3.9", "2", "4.3", "5.3"},
                (Object) new String[]{"a", "2", "4.3", "5.3"}).map(Arguments::of);
    }
}
