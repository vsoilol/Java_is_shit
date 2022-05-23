import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        IntegerSumDigitsComparator comparator = new IntegerSumDigitsComparator();

        Integer[] array = new Integer[]{34, 12, 107, 2003};

        System.out.println(Arrays.toString(Arrays.stream(array).sorted(comparator).toArray()));
    }
}
