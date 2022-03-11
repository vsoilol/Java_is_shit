package Providers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class InvalidParameters implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                (Object) new String[]{"3", "2", "0", "0"},
                (Object) new String[]{"3", "0", "4.3", "5.3"},
                (Object) new String[]{"3", "0", "-5.3", "5.3"},
                (Object) new String[]{"3", "0", "5.3", "-5.3"}).map(Arguments::of);
    }
}
