package Card;

import java.math.BigDecimal;

public class Card {
    private String holderName;
    private BigDecimal balance;

    public Card(String holderName, BigDecimal balance){
        this.holderName = holderName;
        this.balance = balance;
    }

    public Card(String holderName){
        this.holderName = holderName;
        this.balance = BigDecimal.valueOf(0);
    }

    public BigDecimal getBalance(){
        return balance;
    }

    public void addMoneyToBalance(BigDecimal money){
        balance = balance.add(money);
    }

    public void withdrawMoneyFrom(BigDecimal money) throws NumberFormatException{
        if(money.compareTo(balance) == 1){
            throw new NumberFormatException("больше чем надо");
        }
        balance = balance.subtract(money);
    }

    public BigDecimal convertMoneyByExchangeRate(double exchangeRate) throws NumberFormatException{
        if(exchangeRate <= 0){
            throw new NumberFormatException("Exchange rate cannot be less than zero");
        }
        return balance.multiply(BigDecimal.valueOf(exchangeRate));
    }

    @Override
    public String toString() {
        return "holderName = " + holderName +
                ", balance = " + balance;
    }
}
