package Card;

import Resources.ErrorMessages;

import java.math.BigDecimal;

public class Card {
    private String holderName;
    private BigDecimal balance;

    public Card(String holderName, BigDecimal balance) {
        this.holderName = holderName;
        this.balance = balance;
    }

    public Card(String holderName) {
        this.holderName = holderName;
        this.balance = BigDecimal.valueOf(0);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getHolderName() {
        return holderName;
    }

    public void addMoneyToBalance(BigDecimal money) {
        balance = balance.add(money);
    }

    public void withdrawMoneyFrom(BigDecimal money) throws NumberFormatException {
        if (money.compareTo(balance) == 1) {
            throw new NumberFormatException(ErrorMessages.CANNOT_WITHDRAW_MONEY);
        }
        balance = balance.subtract(money);
    }

    public BigDecimal convertMoneyByExchangeRate(double exchangeRate) throws NumberFormatException {
        return balance.multiply(BigDecimal.valueOf(exchangeRate));
    }
}
