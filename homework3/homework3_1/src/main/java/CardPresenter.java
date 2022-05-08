import java.math.BigDecimal;

public class CardPresenter {
    private final Console console;
    private final Card card;

    public CardPresenter(Card card) {
        this.card = card;
        console = new Console();
    }

    public void addMoney() {
        BigDecimal money = console.readLine("Enter the amount you want to deposit to the account: ", BigDecimal.class);
        card.addMoneyToBalance(money);
        console.writeLine("Success!!!");
    }

    public void convertMoneyByExchangeRate() {
        Double exchangeRate = console.readLine("Please enter exchange rate: ", Double.class);
        BigDecimal convertedMoney = card.convertMoneyByExchangeRate(exchangeRate);
        console.writeLine("Converted money: " + convertedMoney);
    }

    public void displayBalance() {
        console.writeLine("Balance: " + card.getBalance());
    }

    public void withdrawMoney() {
        BigDecimal money = console.readLine("Enter the amount you want to withdraw to the account: ", BigDecimal.class);

        try {
            card.withdrawMoneyFrom(money);
        } catch (NumberFormatException ex) {
            console.writeLine(ex.getMessage());
            return;
        }

        console.writeLine("Success!!!");
    }
}
