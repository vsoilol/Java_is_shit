package Providers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class InvalidValues implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                (Object) new String[]{"3", "2", "7"},
                (Object) new String[]{"1", "4", "7"},
                (Object) new String[]{"1", "2", "-2"},
                (Object) new String[]{"-2", "2", "7"},
                (Object) new String[]{"2", "-2", "7"},
                (Object) new String[]{"2", "2", "-7"}).map(Arguments::of);
    }
}
