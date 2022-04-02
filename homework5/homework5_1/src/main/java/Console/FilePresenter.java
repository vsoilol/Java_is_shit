package Console;

import FileSystem.FileSystemTree;
import FileSystem.FileSystemBuilder;
import Resources.UIResources;
import Validators.FilePresenterValidator;

public class FilePresenter {
    private final ConsoleProvider consoleProvider;

    private final FileSystemBuilder builder;
    private final FileSystemTree fileSystemTree;

    private final FilePresenterValidator validator;

    public FilePresenter(FileSystemBuilder builder,
                         FileSystemTree fileSystemTree,
                         FilePresenterValidator validator,
                         ConsoleProvider consoleProvider) {
        this.fileSystemTree = fileSystemTree;
        this.validator = validator;
        this.builder = builder;
        this.consoleProvider = consoleProvider;
    }

    public void displayDirectoryTree() {
        consoleProvider.print(fileSystemTree.printDirectoryTree(builder.getRootFolder()));
    }

    public void addNewChild(String path) {
        try {
            validator.checkFilePath(path);

            String[] filesName = path.split("/");
            builder.addFileTreeByFilesName(filesName);

            consoleProvider.println(UIResources.SUCCESS);
        } catch (Exception ex) {
            consoleProvider.println(ex.getMessage());
        }
    }
}
