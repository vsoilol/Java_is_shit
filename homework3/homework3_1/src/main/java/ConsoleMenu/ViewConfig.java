package ConsoleMenu;

public class ViewConfig {

    public static final ViewConfig DEFAULT = new ViewConfig();

    public String getIndexNumberFormatter(int index) {
        return (index + 1) + ") ";
    }
}
