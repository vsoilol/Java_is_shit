package ATMActions;

import Card.Card;
import Resources.UIResources;
import Validators.ExchangeRateValidator;

import java.math.BigDecimal;

public class WithdrawMoney extends CardMenuItem {
    public WithdrawMoney(Card card) {
        super(card, "Withdraw money", "Withdrawing money");
    }

    @Override
    public void executeCustomAction() {
        BigDecimal money = consoleProvider.prompt(UIResources.ENTER_MONEY_TO_WITHDRAW, BigDecimal.class, new ExchangeRateValidator());

        try {
            card.withdrawMoneyFrom(money);
        } catch (NumberFormatException ex) {
            consoleProvider.println(ex.getMessage());
            return;
        }

        consoleProvider.println(UIResources.SUCCESS);
    }
}
