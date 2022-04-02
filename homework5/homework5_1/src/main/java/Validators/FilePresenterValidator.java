package Validators;

import Resources.ErrorMessages;
import Resources.RegularExpressions;

public class FilePresenterValidator {
    public void checkFilePath(String filePath) throws IllegalArgumentException {
        if (!filePath.matches(RegularExpressions.FILE_PATH)) {
            throw new IllegalArgumentException(ErrorMessages.FILE_PATH_INCORRECT);
        }
    }
}
