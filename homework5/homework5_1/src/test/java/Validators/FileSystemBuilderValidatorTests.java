package Validators;

import ValidationModels.FilesNameValidationInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileSystemBuilderValidatorTests {
    private final FileSystemBuilderValidator validator = new FileSystemBuilderValidator();

    private final String rootFolderName = "root";

    @Test
    public void testCheckFilesNameWhenRootNameIsNotEqual() {
        String[] filesName = new String[]{"roo", "sdf", "dfsd"};
        FilesNameValidationInfo info = new FilesNameValidationInfo(filesName, rootFolderName);

        assertThrows(IllegalArgumentException.class, () -> validator.check(info));
    }

    @Test
    public void testCheckFilesNameWhenFilesNameLengthEqualOne() {
        String[] filesName = new String[]{"root"};
        FilesNameValidationInfo info = new FilesNameValidationInfo(filesName, rootFolderName);

        assertThrows(IllegalArgumentException.class, () -> validator.check(info));
    }

    @Test
    public void testCheckFilesNameShouldNotThrowException() {
        String[] filesName = new String[]{"root", "sfsd", "dsdf"};
        FilesNameValidationInfo info = new FilesNameValidationInfo(filesName, rootFolderName);

        assertDoesNotThrow(() -> validator.check(info));
    }
}
