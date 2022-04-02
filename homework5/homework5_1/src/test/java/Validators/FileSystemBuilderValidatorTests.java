package Validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileSystemBuilderValidatorTests {
    private final FileSystemBuilderValidator validator = new FileSystemBuilderValidator();

    private final String rootFolderName = "root";

    @Test
    public void testCheckFilesNameWhenRootNameIsNotEqual() {
        String[] filesName = new String[]{"roo", "sdf", "dfsd"};

        assertThrows(IllegalArgumentException.class, () -> validator.checkFilesName(filesName, rootFolderName));
    }

    @Test
    public void testCheckFilesNameWhenFilesNameLengthEqualOne() {
        String[] filesName = new String[]{"root"};

        assertThrows(IllegalArgumentException.class, () -> validator.checkFilesName(filesName, rootFolderName));
    }

    @Test
    public void testCheckFilesNameShouldNotThrowException() {
        String[] filesName = new String[]{"root", "sfsd", "dsdf"};

        assertDoesNotThrow(() -> validator.checkFilesName(filesName, rootFolderName));
    }
}
