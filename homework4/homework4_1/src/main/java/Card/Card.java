package Card;

import java.math.BigDecimal;

public abstract class Card {
    private String holderName;
    protected BigDecimal balance;

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

    public abstract void withdrawMoneyFrom(BigDecimal money);

    public BigDecimal convertMoneyByExchangeRate(double exchangeRate) throws NumberFormatException {
        return balance.multiply(BigDecimal.valueOf(exchangeRate));
    }
}
