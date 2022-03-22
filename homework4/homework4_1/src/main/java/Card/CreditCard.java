package Card;

import java.math.BigDecimal;

public class CreditCard extends Card{
    public CreditCard(String holderName, BigDecimal balance) {
        super(holderName, balance);
    }

    public CreditCard(String holderName){
        super(holderName);
    }

    @Override
    public void withdrawMoneyFrom(BigDecimal money) {
        balance = balance.subtract(money);
    }
}
