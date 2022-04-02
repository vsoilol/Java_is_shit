package FileInfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileTests {
    private File file;

    private final String name = "file";
    private final String extension = "txt";

    @BeforeEach
    public void init() {
        file = new File(name, extension);
    }

    @Test
    public void testGetNameShouldWorkAsExpected() {
        String expected = name + "." + extension;

        String actual = file.getName();

        assertEquals(expected, actual);
    }
}
