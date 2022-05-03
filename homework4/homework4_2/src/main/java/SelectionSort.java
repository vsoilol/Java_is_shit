public class SelectionSort extends Sorter {
    @Override
    public void sort(Integer[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            swapElements(array, minIndex, i);
        }
    }
}
