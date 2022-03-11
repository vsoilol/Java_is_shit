import ATMActions.AddMoney;
import ATMActions.ConvertMoneyByExchangeRate;
import ATMActions.DisplayBalance;
import ATMActions.WithdrawMoney;
import Card.Card;
import ConsoleMenu.Menu;

public class Main {
    public static void main(String[] args) {
        Card card = new Card("Vlad");

        Menu atm = new Menu("ATM (account holder: " + card.getHolderName() + ")");
        atm.addMenuItem(new DisplayBalance(card));
        atm.addMenuItem(new AddMoney(card));
        atm.addMenuItem(new WithdrawMoney(card));
        atm.addMenuItem(new ConvertMoneyByExchangeRate(card));

        atm.display();
    }
}
