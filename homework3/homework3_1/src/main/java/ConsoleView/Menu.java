package ConsoleView;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String title;

    private List<MenuItem> menuItems = new ArrayList<>();

    private final ConsoleProvider consoleProvider;

    protected ViewConfig viewConfig;

    private Menu previousMenu;

    public Menu(String title) {
        this.title = title;
        consoleProvider = new ConsoleProvider();
        this.viewConfig = ViewConfig.DEFAULT;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItem.setParentMenu(this);
        this.menuItems.add(menuItem);
    }

    private boolean isValidIndex(int index) {
        return index >= 1 && index <= this.menuItems.size() + 1;
    }

    public Boolean hasPreviousMenu() {
        return previousMenu != null;
    }

    protected void onBack() {
        consoleProvider.println(UIResources.BACK_MESSAGE);
    }

    protected void onQuit() {
        consoleProvider.println(UIResources.QUIT_MESSAGE);
    }

    protected void goBack() {
        if (hasPreviousMenu()) {

            onBack();

            this.previousMenu.display();
        }

        // if there is no parent view, call .onBack() and quit
        else {
            this.onQuit();
            System.exit(0);
        }
    }

    public void display() {
        consoleProvider.println();

        consoleProvider.println(title);

        for (int i = 0; i < this.menuItems.size(); ++i) {
            this.consoleProvider.println(this.viewConfig.getIndexNumberFormatter().format(i) + this.menuItems.get(i).getTitle());
        }

        String backOrQuit = this.previousMenu == null ? this.viewConfig.getQuitMenuName() : this.viewConfig.getBackMenuName();

        // 4) Back/quit; always the last index
        consoleProvider.println(this.viewConfig.getIndexNumberFormatter().format(this.menuItems.size()) + backOrQuit);

        // get a valid index number
        Validator<Integer> indexNumberValidator = new Validator<Integer>() {
            @Override
            public boolean isValid(Integer index) {
                return isValidIndex(index);
            }
        };

        int selection = consoleProvider.prompt(this.viewConfig.getMenuSelectionMessage(), Integer.class, indexNumberValidator);

        // go parentView
        if (selection == this.menuItems.size() + 1) {
            this.goBack();
        } else {
            this.menuItems.get(selection - 1).display();
        }

        this.goBack();
    }

    public void setPreviousMenu(Menu menu){
        previousMenu = menu;
    }
}
