package Validators;

import Resources.ErrorMessages;

import java.util.Objects;

public class FileSystemBuilderValidator {
    public void checkFilesName(String[] filesName, String rootFolderName) {
        if (!Objects.equals(rootFolderName, filesName[0])) {
            throw new IllegalArgumentException(ErrorMessages.FOLDER_DOES_NOT_EXIST.formatted(filesName[0]));
        }
    }
}
