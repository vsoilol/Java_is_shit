package ATMActions;

import ConsoleMenu.*;

public class BookTaxiAction extends MenuItem {
    public BookTaxiAction(){
        super("Book a taxi", "Booking a Taxi");
    }

    @Override
    public void executeCustomAction() {
        String line = consoleProvider.prompt("Please enter a line: ", String.class);

        Menu menuView = new Menu("Submenu " + line);

        menuView.setPreviousMenu(this.parentMenu);

        menuView.display();
    }
}
