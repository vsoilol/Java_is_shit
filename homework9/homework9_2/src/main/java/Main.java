import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<String> a = new HashSet<>(){{
            add("A");
            add("B");
        }};
        HashSet<String> b = new HashSet<>(){{
            add("B");
            add("C");
        }};

        System.out.println(HashSetUtility.union(a, b));
        System.out.println(HashSetUtility.intersection(a, b));
        System.out.println(HashSetUtility.minus(a, b));
        System.out.println(HashSetUtility.difference(a, b));
    }
}
