package ConsoleMenu;

public abstract class MenuItem {
    private final String runningTitle;

    private final String title;

    protected final ConsoleProvider consoleProvider;

    protected Menu parentMenu;

    public MenuItem(String title, String runningTitle) {
        this.runningTitle = runningTitle;
        this.title = title;
        this.consoleProvider = ConsoleProvider.getInstance();
    }

    public abstract void executeCustomAction();

    public void display() {
        consoleProvider.println();
        consoleProvider.println(this.runningTitle);
        executeCustomAction();
        parentMenu.display();
    }

    public String getTitle() {
        return title;
    }

    public void setParentMenu(Menu menu) {
        parentMenu = menu;
    }
}
