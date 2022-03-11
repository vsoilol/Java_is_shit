package CardViewActions;

import ConsoleView.*;

public class BookTaxiAction extends MenuItem {
    public BookTaxiAction(){
        super("Booking a Taxi", "Book a taxi");
    }

    @Override
    public void executeCustomAction() {
        String line = consoleProvider.prompt("Please enter a line: ", String.class);

        Menu menuView = new Menu("Submenu " + line);

        menuView.setPreviousMenu(this.parentMenu);

        menuView.display();
    }
}
