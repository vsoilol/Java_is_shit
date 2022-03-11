import Extensions.ArrayExtension;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayExtensionTest {
    @Test
    public void testToStringWithCommaShouldWorkAsExpected() {
        int[] array = new int[]{1, 2, 63, 25};
        String expected = "1, 2, 63, 25";

        String actual = ArrayExtension.toStringWithComma(array);

        assertEquals(expected, actual);
    }
}
