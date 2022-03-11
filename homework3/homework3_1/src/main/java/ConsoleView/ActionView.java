package ConsoleView;

public abstract class ActionView extends AbstractView {

    public ActionView(String runningTitle, String nameInParentMenu) {
        super(runningTitle, nameInParentMenu);
    }

    public ActionView(String runningTitle, String nameInParentMenu, ViewConfig viewConfig) {
        super(runningTitle, nameInParentMenu, viewConfig);
    }

    /**
     * to create your custom {@code ActionView} subclass, implement this method
     * to execute your custom logic between printing the title and go back to
     * the parent view
     */
    public abstract void executeCustomAction();

    @Override
    public void display() {
        this.println();
        this.println(this.runningTitle);
        this.executeCustomAction();
        this.goBack();
    }
}
