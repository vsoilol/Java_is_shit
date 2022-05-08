public class SortingContext {
    private final Sorter sortStrategy;

    public SortingContext(Sorter sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void execute(Integer[] array) {
        sortStrategy.sort(array);
    }
}
