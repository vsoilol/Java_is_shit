package ATMActions;

import Card.Card;
import ConsoleMenu.MenuItem;

public abstract class CardMenuItem extends MenuItem {
    protected final Card card;

    public CardMenuItem(Card card, String title, String runningTitle) {
        super(title, runningTitle);
        this.card = card;
    }

    public abstract void executeCustomAction();
}
