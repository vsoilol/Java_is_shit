import ATMActions.AddMoney;
import ATMActions.BookTaxiAction;
import ATMActions.DisplayBalance;
import Card.Card;
import ConsoleMenu.Menu;

public class Main {
    public static void main(String[] args) {
        Card card = new Card("Vlad");

        Menu atm = new Menu("ATM");
        atm.addMenuItem(new BookTaxiAction());
        atm.addMenuItem(new DisplayBalance(card));
        atm.addMenuItem(new AddMoney(card));
        atm.display();
    }
}
