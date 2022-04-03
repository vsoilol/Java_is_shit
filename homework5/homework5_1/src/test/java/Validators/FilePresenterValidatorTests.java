package Validators;

import Providers.CorrectPathProvider;
import Providers.IncorrectPathProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.*;

public class FilePresenterValidatorTests {
    private final FilePresenterValidator validator = new FilePresenterValidator();

    @ParameterizedTest
    @ArgumentsSource(CorrectPathProvider.class)
    public void testCheckFilePathShouldNotThrowIllegalArgumentException(String path) {
        assertDoesNotThrow(() -> validator.check(path));
    }

    @ParameterizedTest
    @ArgumentsSource(IncorrectPathProvider.class)
    public void testCheckFilePathShouldThrowIllegalArgumentException(String path) {
        assertThrows(IllegalArgumentException.class, () -> validator.check(path));
    }
}
