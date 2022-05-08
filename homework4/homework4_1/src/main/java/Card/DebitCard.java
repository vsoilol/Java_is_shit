package Card;

import java.math.BigDecimal;

public class DebitCard extends Card {
    public DebitCard(String holderName, BigDecimal balance) {
        super(holderName, balance);
    }

    public DebitCard(String holderName) {
        super(holderName);
    }

    @Override
    public void withdrawMoneyFrom(BigDecimal money) {
        if (money.compareTo(balance) > 0) {
            throw new NumberFormatException("Cannot withdraw such an amount from the balance");
        }
        balance = balance.subtract(money);
    }
}
