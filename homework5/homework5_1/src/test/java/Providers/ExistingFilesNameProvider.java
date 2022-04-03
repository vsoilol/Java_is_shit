package Providers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ExistingFilesNameProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of((Object) new String[]{"root", "folder1"}),
                Arguments.of((Object) new String[]{"root", "folder1", "file1.txt"}),
                Arguments.of((Object) new String[]{"root", "file2.txt"})
        );
    }
}
