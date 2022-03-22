public abstract class Sorter {
    abstract void sort(Integer[] array);

    protected void swapElements(Integer[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
