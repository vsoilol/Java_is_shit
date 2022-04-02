import Console.ConsoleProvider;
import Console.FilePresenter;
import Console.FileValidation;
import Console.SimpleMenu;
import FileInfo.File;
import FileInfo.FileAssert;
import FileInfo.FileService;
import FileInfo.Folder;

public class Main {
    public static void main(String[] args) {
        Folder data = new Folder("root");

        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        File file3 = new File("file3.txt");
        File file4 = new File("file4.txt");
        File file5 = new File("file5.txt");
        File file6 = new File("file6.txt");

        Folder folder1 = new Folder("dir1");
        Folder folder2 = new Folder("dir1");

        folder1.add(file1);
        folder1.add(file2);

        folder2.add(file5);
        folder2.add(file6);

        data.add(folder1);
        data.add(folder2);
        data.add(file3);
        data.add(file4);

        FileService fileService = new FileService();
        FileValidation fileValidation = new FileValidation();
        FilePresenter filePresenter = new FilePresenter(fileService, fileValidation, data);
        ConsoleProvider consoleProvider = new ConsoleProvider();

        SimpleMenu simpleMenu = new SimpleMenu(filePresenter, consoleProvider);
        simpleMenu.runMenu();

        //FileAssert fileAssert = new FileAssert();
//        String fileTree =  FileAssert.printDirectoryTree(data);
//        consoleProvider.println(fileTree);
    }
}
