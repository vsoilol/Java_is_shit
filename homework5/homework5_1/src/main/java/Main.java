import Console.ConsoleProvider;
import Console.FilePresenter;
import Console.FileValidation;
import Console.SimpleMenu;
import FileInfo.FileService;
import FileInfo.Folder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Folder data = new Folder("root", List.of());

        FileService fileService = new FileService();
        FileValidation fileValidation = new FileValidation();
        FilePresenter filePresenter = new FilePresenter(fileService, fileValidation, data);
        ConsoleProvider consoleProvider = new ConsoleProvider();

        SimpleMenu simpleMenu = new SimpleMenu(filePresenter, consoleProvider);
        simpleMenu.runMenu();
    }
}
