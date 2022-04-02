import Console.ConsoleProvider;
import Console.FilePresenter;
import Console.SimpleMenu;
import FileInfo.*;
import Validators.FilePresenterValidator;
import Validators.FileSystemBuilderValidator;

public class Main {
    public static void main(String[] args) {
        FilePresenterValidator filePresenterValidator = new FilePresenterValidator();
        FileSystemBuilderValidator fileSystemBuilderValidator = new FileSystemBuilderValidator();

        FileSystemBuilder builder = new FileSystemBuilder(fileSystemBuilderValidator, "root");
        FilePresenter filePresenter = new FilePresenter(builder, filePresenterValidator);

        ConsoleProvider consoleProvider = new ConsoleProvider();

        SimpleMenu simpleMenu = new SimpleMenu(filePresenter, consoleProvider);
        simpleMenu.runMenu();
    }
}
