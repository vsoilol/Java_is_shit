package ATMActions;

import Card.Card;

public class DisplayBalance extends CardMenuItem {
    public DisplayBalance(Card card) {
        super(card, "Display balance", "Displaying balance");
    }

    @Override
    public void executeCustomAction() {
        consoleProvider.println("Balance: " + card.getBalance());
    }
}
