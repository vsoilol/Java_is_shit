package Console;

import FileInfo.Folder;
import Resources.ErrorMessages;
import Resources.RegularExpressions;

import java.util.Objects;

public class FileValidation {
    public String[] validatePath(Folder parent, String path){
        if(path.matches(RegularExpressions.FILE_PATH)){
            throw new IllegalArgumentException(ErrorMessages.FILE_PATH_INCORRECT);
        }

        String[] filesName = path.split("/");

        if(Objects.equals(parent.getName(), filesName[0])){
            throw new IllegalArgumentException(ErrorMessages.FOLDER_DOES_NOT_EXIST.formatted(filesName[0]));
        }

        return filesName;
    }
}
