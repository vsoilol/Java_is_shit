package Card;

import Resources.ErrorMessages;

import java.math.BigDecimal;

public class DebitCard extends Card{
    public DebitCard(String holderName, BigDecimal balance) {
        super(holderName, balance);
    }

    public DebitCard(String holderName){
        super(holderName);
    }

    @Override
    public void withdrawMoneyFrom(BigDecimal money) {
        if (money.compareTo(balance) > 0) {
            throw new NumberFormatException(ErrorMessages.CANNOT_WITHDRAW_MONEY);
        }
        balance = balance.subtract(money);
    }
}
