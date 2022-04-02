package FileSystem;

import FileInfo.File;
import FileInfo.FileComponent;
import FileInfo.Folder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileSystemTreeTests {
    private Folder folder1;
    private final FileSystemTree fileSystemTree = new FileSystemTree();

    @BeforeEach
    public void setUp() {
        folder1 = new Folder("folder1");
    }

    @Test
    public void testPrintDirectoryTreeWhenFolderIsEmpty() {
        String actual = fileSystemTree.printDirectoryTree(folder1);

        assertEquals("+--folder1/\n", actual);
    }

    private static final String EXPECTED_ONE_FILE_IN_FOLDER = "" + "+--folder1/\n"
            + "|  +--a.txt\n";

    @Test
    public void testPrintDirectoryTreeWhenFolderContainsOneFile() {
        FileComponent file = new File("a", "txt");
        folder1.addFileComponent(file);

        String actual = fileSystemTree.printDirectoryTree(folder1);

        assertEquals(EXPECTED_ONE_FILE_IN_FOLDER, actual);
    }

    private static final String EXPECTED_COMPLEX = "+--folder1/\n"
            + "|  +--a.txt\n" + "|  +--folder2/\n" + "|  |  +--b1.txt\n"
            + "|  |  +--b2.txt\n" + "|  |  +--b3.txt\n" + "|  |  +--folder3/\n"
            + "|  +--folder4/\n";

    @Test
    public void testPrintDirectoryTreeComplex() {
        addSeveralFoldersWithFiles();

        String actual = fileSystemTree.printDirectoryTree(folder1);

        assertEquals(EXPECTED_COMPLEX, actual);
    }

    @Test
    public void testPrintDirectoryTreeWhenFolderIsFile() {
        FileComponent file = new File("file1", "txt");

        assertThrows(IllegalArgumentException.class, () -> fileSystemTree.printDirectoryTree(file));
    }

    private void addSeveralFoldersWithFiles() {
        File aFile = new File("a", "txt");
        folder1.addFileComponent(aFile);

        Folder folder2 = new Folder("folder2");

        File b1File = new File("b1", "txt");
        File b2File = new File("b2", "txt");

        folder2.addFileComponent(b1File);
        folder2.addFileComponent(b2File);

        folder1.addFileComponent(folder2);

        File b3File = new File("b3", "txt");
        folder2.addFileComponent(b3File);

        Folder folder3 = new Folder("folder3");
        folder2.addFileComponent(folder3);

        Folder folder4 = new Folder("folder4");
        folder1.addFileComponent(folder4);
    }
}
