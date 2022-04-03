package FileSystem;

import FileInfo.File;
import FileInfo.FileComponent;
import FileInfo.Folder;
import Providers.ExistingFilesNameProvider;
import Validators.FileSystemBuilderValidator;
import ValidationModels.FilesNameValidationInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

public class FileSystemBuilderTests {
    private final Folder rootFolder = new Folder("root");

    private FileSystemBuilder builder;

    @BeforeEach
    public void init() {
        FileSystemBuilderValidator validator = mock(FileSystemBuilderValidator.class);
        doNothing().when(validator).check(isA(FilesNameValidationInfo.class));

        builder = new FileSystemBuilder(validator, rootFolder);
    }

    @Test
    public void testGetRootFolderShouldWorkAsExpected() {
        Folder actual = builder.getRootFolder();

        assertNotNull(actual);
        assertEquals(rootFolder.getName(), actual.getName());
    }

    @ParameterizedTest
    @ArgumentsSource(ExistingFilesNameProvider.class)
    public void testAddFileTreeByFilesNameShouldThrowIllegalArgumentException(String[] filesName) {
        addFilesToRootFolder();
        assertThrows(IllegalArgumentException.class, () -> builder.addFileTreeByFilesName(filesName));
    }

    @Test
    public void testAddFileTreeByFilesNameShouldCreateNewFolder() {
        String[] filesName = new String[]{"root", "folder3"};

        builder.addFileTreeByFilesName(filesName);

        FileComponent newFolder = builder.getRootFolder().getSubFileComponents().get(0);

        assertNotNull(newFolder);
        assertTrue(newFolder instanceof Folder);
        assertEquals(filesName[1], newFolder.getName());
    }

    @Test
    public void testAddFileTreeByFilesNameShouldCreateNewFile() {
        String[] filesName = new String[]{"root", "file.txt"};

        builder.addFileTreeByFilesName(filesName);

        FileComponent newFile = builder.getRootFolder().getSubFileComponents().get(0);

        assertNotNull(newFile);
        assertTrue(newFile instanceof File);
        assertEquals(filesName[1], newFile.getName());
    }

    @Test
    public void testAddFileTreeByFilesNameShouldCreateFolderWithFile() {
        String[] filesName = new String[]{"root", "folder", "file.txt"};

        builder.addFileTreeByFilesName(filesName);

        FileComponent newFolder = builder.getRootFolder().getSubFileComponents().get(0);

        assertNotNull(newFolder);
        assertTrue(newFolder instanceof Folder);
        assertEquals(filesName[1], newFolder.getName());

        FileComponent newFile = ((Folder) newFolder).getSubFileComponents().get(0);

        assertNotNull(newFile);
        assertTrue(newFile instanceof File);
        assertEquals(filesName[2], newFile.getName());
    }

    public void addFilesToRootFolder() {
        File file1 = new File("file1", "txt");
        File file2 = new File("file2", "txt");
        File file3 = new File("file3", "txt");
        File file4 = new File("file4", "txt");

        Folder folder1 = new Folder("folder1");
        Folder folder2 = new Folder("folder2");

        folder1.addFileComponent(file1);
        folder2.addFileComponent(file3);
        folder2.addFileComponent(file4);

        rootFolder.addFileComponent(folder1);
        rootFolder.addFileComponent(folder2);
        rootFolder.addFileComponent(file2);
    }
}
