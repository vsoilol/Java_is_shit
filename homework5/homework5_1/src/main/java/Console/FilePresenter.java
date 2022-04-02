package Console;

import FileInfo.FileAssert;
import FileInfo.FileSystemBuilder;
import Resources.ErrorMessages;
import Resources.RegularExpressions;
import Resources.UIResources;
import Validators.FilePresenterValidator;

public class FilePresenter {
    private final ConsoleProvider consoleProvider;
    private final FileSystemBuilder builder;
    private final FilePresenterValidator validator;

    public FilePresenter(FileSystemBuilder builder, FilePresenterValidator validator) {
        this.validator = validator;
        this.builder = builder;
        this.consoleProvider = ConsoleProvider.getInstance();
    }

    public void displayDirectoryTree() {
        consoleProvider.print(FileAssert.printDirectoryTree(builder.getRootFolder()));
    }

    public void addNewChild(String path) {
        try{
            validator.checkFilePath(path);

            String[] filesName = path.split("/");
            builder.addFileTreeByFilesName(filesName);

            consoleProvider.println(UIResources.SUCCESS);
        }
        catch (Exception ex){
            consoleProvider.println(ex.getMessage());
        }
    }
}
