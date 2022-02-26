package Providers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ParametersWithIncorrectLength implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                (Object) new String[]{"3"},
                (Object) new String[]{"3", "6"},
                (Object) new String[]{"3", "6", "2.3"},
                (Object) new String[]{"3", "6", "2.3", "5.1", "2.3"},
                (Object) new String[]{"3", "6", "2.3", "5.1", "2.3", "8"}).map(Arguments::of);
    }
}
