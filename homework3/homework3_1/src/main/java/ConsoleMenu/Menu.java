package ConsoleMenu;

import Validators.Validator;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final String title;

    private final List<MenuItem> menuItems = new ArrayList<>();

    private final ConsoleProvider consoleProvider;

    protected ViewConfig viewConfig;

    private Menu previousMenu;

    public Menu(String title) {
        this.title = title;
        this.consoleProvider = ConsoleProvider.DEFAULT;
        this.viewConfig = ViewConfig.DEFAULT;
    }

    public void setPreviousMenu(Menu menu) {
        this.previousMenu = menu;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItem.setParentMenu(this);
        this.menuItems.add(menuItem);
    }

    public void display() {
        this.consoleProvider.println();
        this.consoleProvider.println(title);

        this.displayMenuItems();
        this.chooseMenuItem();
    }

    public void goBack() {
        if (this.hasPreviousMenu()) {
            this.consoleProvider.println(UIResources.BACK_MESSAGE);
        } else {
            this.consoleProvider.println(UIResources.QUIT_MESSAGE);
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 1 && index <= this.menuItems.size() + 1;
    }

    private Boolean hasPreviousMenu() {
        return this.previousMenu != null;
    }

    private void chooseMenuItem() {
        Validator<Integer> indexNumberValidator = this::isValidIndex;

        int selection = this.consoleProvider.prompt(UIResources.MENU_SELECTION_MESSAGE, Integer.class, indexNumberValidator);

        if (selection != this.menuItems.size() + 1) {
            this.menuItems.get(selection - 1).display();
        }
        else{
            this.goBack();
        }
    }

    private void displayMenuItems() {
        for (int i = 0; i < this.menuItems.size(); ++i) {
            this.consoleProvider.println(this.viewConfig.getIndexNumberFormatter(i) + this.menuItems.get(i).getTitle());
        }

        String backOrQuit = this.previousMenu == null ? UIResources.QUIT_MENU_NAME : UIResources.BACK_MENU_NAME;

        this.consoleProvider.println(this.viewConfig.getIndexNumberFormatter(this.menuItems.size()) + backOrQuit);
    }
}
