import java.util.Arrays;

public final class Median {
    public static Double median(int[] values) {
        Arrays.sort(values);
        double median;

        int totalElements = values.length;

        if (totalElements % 2 == 0) {
            int sumOfMiddleElements = values[totalElements / 2] +
                    values[totalElements / 2 - 1];

            median = ((double) sumOfMiddleElements) / 2;
        } else {
            median = values[values.length / 2];
        }
        return median;
    }

    public static Double median(Double[] values) {
        Arrays.sort(values);
        double median;

        int totalElements = values.length;

        if (totalElements % 2 == 0) {
            double sumOfMiddleElements = values[totalElements / 2] +
                    values[totalElements / 2 - 1];

            median = sumOfMiddleElements / 2;
        } else {
            median = values[values.length / 2];
        }
        return median;
    }
}
