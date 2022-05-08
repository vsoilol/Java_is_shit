import java.math.BigDecimal;

public class Card {
    private final String holderName;
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
            throw new NumberFormatException("Cannot withdraw such an amount from the balance");
        }
        balance = balance.subtract(money);
    }

    public BigDecimal convertMoneyByExchangeRate(double exchangeRate) {
        return balance.multiply(BigDecimal.valueOf(exchangeRate));
    }
}
