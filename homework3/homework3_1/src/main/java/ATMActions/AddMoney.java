package ATMActions;

import Card.Card;
import Resources.UIResources;
import Validators.ExchangeRateValidator;

import java.math.BigDecimal;

public class AddMoney extends CardMenuItem {
    public AddMoney(Card card) {
        super(card, "Add money", "Adding money");
    }

    @Override
    public void executeCustomAction() {
        BigDecimal money = this.consoleProvider.prompt(UIResources.ENTER_MONEY_TO_ADD, BigDecimal.class, new ExchangeRateValidator());
        card.addMoneyToBalance(money);
        this.consoleProvider.println(UIResources.SUCCESS);
    }
}
