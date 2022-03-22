package ConsoleMenu;

import Resources.UIResources;
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
        this.consoleProvider = ConsoleProvider.getInstance();
        this.viewConfig = ViewConfig.getInstance();
    }

    public void setPreviousMenu(Menu menu) {
        previousMenu = menu;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItem.setParentMenu(this);
        menuItems.add(menuItem);
    }

    public void display() {
        consoleProvider.println();
        consoleProvider.println(title);

        displayMenuItems();
        chooseMenuItem();
    }

    public void goBack() {
        if (hasPreviousMenu()) {
            consoleProvider.println(UIResources.BACK_MESSAGE);
        } else {
            consoleProvider.println(UIResources.QUIT_MESSAGE);
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 1 && index <= menuItems.size() + 1;
    }

    private Boolean hasPreviousMenu() {
        return previousMenu != null;
    }

    private void chooseMenuItem() {
        Validator<Integer> indexNumberValidator = this::isValidIndex;

        int selection = consoleProvider.prompt(UIResources.MENU_SELECTION_MESSAGE, Integer.class, indexNumberValidator);

        if (selection != menuItems.size() + 1) {
            menuItems.get(selection - 1).display();
        } else {
            goBack();
        }
    }

    private void displayMenuItems() {
        for (int i = 0; i < menuItems.size(); ++i) {
            consoleProvider.println(viewConfig.getIndexNumberFormatter(i) + menuItems.get(i).getTitle());
        }

        String backOrQuit = previousMenu == null ? UIResources.QUIT_MENU_NAME : UIResources.BACK_MENU_NAME;

        consoleProvider.println(viewConfig.getIndexNumberFormatter(menuItems.size()) + backOrQuit);
    }
}
