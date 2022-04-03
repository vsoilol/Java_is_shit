package Providers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class IncorrectPathProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of("root/dir1"),
                Arguments.of("root/file.txt/dir/"),
                Arguments.of("root/file.txt/file1.txt"),
                Arguments.of("root/file.txt/")
        );
    }
}
