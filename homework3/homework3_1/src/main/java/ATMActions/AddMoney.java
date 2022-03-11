package ATMActions;

import Card.Card;
import ConsoleMenu.MenuItem;
import ConsoleMenu.UIResources;

import java.math.BigDecimal;

public class AddMoney extends CardMenuItem {
    public AddMoney(Card card) {
        super(card, "Add money", "Adding money");
    }

    private boolean isValidMoney(BigDecimal money){
        return money.compareTo(BigDecimal.valueOf(0)) == 1;
    }

    @Override
    public void executeCustomAction() {
        BigDecimal money = this.consoleProvider.prompt(UIResources.ENTER_MONEY_TO_ADD, BigDecimal.class, this::isValidMoney);
        card.addMoneyToBalance(money);
        this.consoleProvider.println(UIResources.SUCCESS);
    }
}
