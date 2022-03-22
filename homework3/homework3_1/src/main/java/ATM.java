import ATMActions.AddMoney;
import ATMActions.ConvertMoneyByExchangeRate;
import ATMActions.DisplayBalance;
import ATMActions.WithdrawMoney;
import Card.Card;
import ConsoleMenu.Menu;

public final class ATM {
    public void run(Card card){
        Menu atm = new Menu("ATM (account holder: " + card.getHolderName() + ")");

        createBasicMenuItem(card, atm);

        atm.display();
    }

    private void createBasicMenuItem(Card card, Menu atm) {
        atm.addMenuItem(new DisplayBalance(card));
        atm.addMenuItem(new AddMoney(card));
        atm.addMenuItem(new WithdrawMoney(card));
        atm.addMenuItem(new ConvertMoneyByExchangeRate(card));
    }
}
