import Console.ConsoleProvider;
import Console.FilePresenter;
import Console.SimpleMenu;
import FileSystem.FileSystemBuilder;
import FileSystem.FileSystemTree;
import Validators.FilePresenterValidator;
import Validators.FileSystemBuilderValidator;

public class Main {
    public static void main(String[] args) {
        FilePresenterValidator filePresenterValidator = new FilePresenterValidator();
        FileSystemBuilderValidator fileSystemBuilderValidator = new FileSystemBuilderValidator();

        ConsoleProvider consoleProvider = new ConsoleProvider();

        FileSystemBuilder builder = new FileSystemBuilder(fileSystemBuilderValidator, "root");
        FileSystemTree fileSystemTree = new FileSystemTree();
        FilePresenter filePresenter = new FilePresenter(builder, fileSystemTree, filePresenterValidator, consoleProvider);

        SimpleMenu simpleMenu = new SimpleMenu(filePresenter, consoleProvider);
        simpleMenu.runMenu();
    }
}
