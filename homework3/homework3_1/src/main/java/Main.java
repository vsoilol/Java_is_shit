import CardViewActions.BookTaxiAction;
import ConsoleView.Menu;
import ConsoleView.MenuView;

public class Main {
    public static void main(String[] args) {
        Menu historyMenu = new Menu("Booking History");

        // register menu items
        historyMenu.addMenuItem(new BookTaxiAction());

        historyMenu.display();
    }
}
