package ATMActions;

import Card.Card;
import Resources.UIResources;
import Validators.MoneyValidator;

import java.math.BigDecimal;

public class ConvertMoneyByExchangeRate extends CardMenuItem {
    public ConvertMoneyByExchangeRate(Card card) {
        super(card, "Convert money by exchange rate", "Converting money");
    }

    @Override
    public void executeCustomAction() {
        Double exchangeRate = this.consoleProvider.prompt(UIResources.ENTER_EXCHANGE_RATE, Double.class, new MoneyValidator());
        BigDecimal convertedMoney = card.convertMoneyByExchangeRate(exchangeRate);
        this.consoleProvider.println(UIResources.CONVERTED_MONEY + convertedMoney);
    }
}
