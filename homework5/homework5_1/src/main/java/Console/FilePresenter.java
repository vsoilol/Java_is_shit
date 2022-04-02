package Console;

import FileInfo.FileService;
import FileInfo.Folder;
import Resources.ErrorMessages;
import Resources.UIResources;

public class FilePresenter {
    private final ConsoleProvider consoleProvider;
    private final FileService fileService;
    private final FileValidation validation;

    private final Folder rootFolder;

    public FilePresenter(FileService fileService, FileValidation validation, Folder rootFolder) {
        this.validation = validation;
        this.rootFolder = rootFolder;
        this.fileService = fileService;
        this.consoleProvider = ConsoleProvider.getInstance();
    }

    public void displayFileTreeView() {
        StringBuilder stringBuilder = new StringBuilder();
        fileService.createFileTreeView(stringBuilder, rootFolder, 0);
        consoleProvider.print(stringBuilder);
    }

    public void addNewChild(String path) {
        try{
            String[] filesName = validation.validatePath(rootFolder, path);
            fileService.addFileTreeByPath(rootFolder, filesName);
            consoleProvider.println(UIResources.SUCCESS);
        }
        catch (Exception ex){
            consoleProvider.println(ex.getMessage());
        }
    }
}
