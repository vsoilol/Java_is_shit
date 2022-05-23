import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class HashSetUtilityTests {
    private final Set<String> firstHashSet = Set.of("A", "B");

    private final Set<String> secondHashSet = Set.of("B", "C");

    @Test
    public void testUnionWorkAsExpected(){
        Set<String> expected = Set.of("A", "B", "C");

        Set<String> actual = HashSetUtility.union(firstHashSet, secondHashSet);

        assertEquals(expected, actual);
    }

    @Test
    public void testIntersectionWorkAsExpected(){
        Set<String> expected = Set.of("B");

        Set<String> actual = HashSetUtility.intersection(firstHashSet, secondHashSet);

        assertEquals(expected, actual);
    }

    @Test
    public void testMinusWorkAsExpected(){
        Set<String> expected = Set.of("A");

        Set<String> actual = HashSetUtility.minus(firstHashSet, secondHashSet);

        assertEquals(expected, actual);
    }

    @Test
    public void testDifferenceWorkAsExpected(){
        Set<String> expected = Set.of("A", "C");

        Set<String> actual = HashSetUtility.difference(firstHashSet, secondHashSet);

        assertEquals(expected, actual);
    }

}
