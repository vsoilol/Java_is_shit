package ConsoleView;

public abstract class MenuItem {
    private final String runningTitle;

    private final String title;

    protected final ConsoleProvider consoleProvider;

    private Menu nextMenu;

    protected Menu parentMenu;

    public MenuItem(String runningTitle, String nameInParentMenu) {
        this.runningTitle = runningTitle;
        this.title = nameInParentMenu;
        this.consoleProvider = new ConsoleProvider();
    }

    public MenuItem(String runningTitle, String nameInParentMenu, Menu nextMenu) {
        this.runningTitle = runningTitle;
        this.title = nameInParentMenu;
        this.consoleProvider = new ConsoleProvider();
        this.nextMenu = nextMenu;
    }

    public abstract void executeCustomAction();

    public void display() {
        consoleProvider.println();
        consoleProvider.println(this.runningTitle);
        executeCustomAction();
    }

    public String getTitle() {
        return title;
    }

    public void setParentMenu(Menu menu){
        this.parentMenu = menu;
    }

    public Menu getParentMenu(){
        return parentMenu;
    }
}
