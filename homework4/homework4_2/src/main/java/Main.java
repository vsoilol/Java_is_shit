import org.apache.commons.lang3.StringUtils;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SortingContext context = new SortingContext(new BubbleSort());

        Random rd = new Random();
        Integer[] arr = new Integer[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(50);
        }

        System.out.print("Unsorted array: ");
        System.out.println(StringUtils.join(arr, ", "));

        context.execute(arr);

        System.out.print("Sorted array: ");
        System.out.println(StringUtils.join(arr, ", "));
    }
}
