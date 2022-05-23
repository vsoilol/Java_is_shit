import java.util.HashSet;
import java.util.Set;

public final class HashSetUtility {
    public static <T> Set<T> union(Set<T> firstSet, Set<T> secondSet) {
        Set<T> union = new HashSet<>();
        union.addAll(firstSet);
        union.addAll(secondSet);

        return union;
    }

    public static <T> Set<T> intersection(Set<T> firstSet, Set<T> secondSet) {
        Set<T> intersection = new HashSet<>(firstSet);
        intersection.retainAll(secondSet);

        return intersection;
    }

    public static <T> Set<T> minus(Set<T> firstSet, Set<T> secondSet) {
        Set<T> difference = new HashSet<>(firstSet);
        difference.removeAll(secondSet);

        return difference;
    }

    public static <T> Set<T> difference(Set<T> firstSet, Set<T> secondSet) {
        Set<T> symmetricDiff = new HashSet<>(firstSet);
        symmetricDiff.addAll(secondSet);
        Set<T> tmp = new HashSet<>(firstSet);
        tmp.retainAll(secondSet);
        symmetricDiff.removeAll(tmp);

        return symmetricDiff;
    }
}
