package FileInfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FolderTests {
    private Folder folder;

    private final String name = "folder";

    @BeforeEach
    public void init() {
        folder = new Folder(name);
    }

    @Test
    public void testGetNameShouldWorkAsExpected() {
        String actual = folder.getName();

        assertEquals(name, actual);
    }

    @Test
    public void testGetSubFileComponentsWhenIsEmpty() {
        ArrayList<FileComponent> fileComponents = folder.getSubFileComponents();

        assertNotNull(fileComponents);
        assertEquals(0, fileComponents.size());
    }

    @Test
    public void testGetSubFileComponentsWhenIsNotEmpty() {
        addFileComponents();

        ArrayList<FileComponent> fileComponents = folder.getSubFileComponents();

        assertNotNull(fileComponents);
        assertEquals(3, fileComponents.size());
    }

    @Test
    public void testAddFileComponentShouldWorkAsExpected() {
        FileComponent folder1 = new Folder("folder1");
        folder.addFileComponent(folder1);

        ArrayList<FileComponent> fileComponents = folder.getSubFileComponents();

        assertNotNull(fileComponents);
        assertEquals(1, fileComponents.size());
        assertEquals(folder1, fileComponents.get(0));
    }

    @Test
    public void testGetFileComponentByNameShouldReturnFileComponent() {
        addFileComponents();
        String fileName = "file1.txt";

        FileComponent fileComponent = folder.getFileComponentByName(fileName);

        assertNotNull(fileComponent);
        assertEquals(fileName, fileComponent.getName());
    }

    @Test
    public void testGetFileComponentByNameShouldReturnNull() {
        addFileComponents();

        FileComponent fileComponent = folder.getFileComponentByName("dfsdf");

        assertNull(fileComponent);
    }

    private void addFileComponents() {
        Folder folder1 = new Folder("folder1");
        File file1 = new File("file1", "txt");
        File file2 = new File("file2", "txt");

        folder.addFileComponent(folder1);
        folder.addFileComponent(file1);
        folder.addFileComponent(file2);
    }
}
