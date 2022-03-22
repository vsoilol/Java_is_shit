package ConsoleMenu;

public class ViewConfig {
    public static ViewConfig getInstance(){
        return new ViewConfig();
    }

    public String getIndexNumberFormatter(int index) {
        return (index + 1) + ") ";
    }
}
