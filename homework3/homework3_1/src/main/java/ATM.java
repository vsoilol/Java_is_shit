public class ATM {
    private final Console console;
    private CardPresenter cardPresenter;

    private boolean isAtmWork = true;

    public ATM() {
        console = new Console();
    }

    public void run(Card card){
        cardPresenter = new CardPresenter(card);

        while (isAtmWork){
            console.writeLine();
            console.writeLine("ATM (account holder: " + card.getHolderName() + ")");

            displayMenuItems();
            chooseMenuItem();
        }
    }

    private void displayMenuItems(){
        console.writeLine("1) Display balance");
        console.writeLine("2) Add money");
        console.writeLine("3) Withdraw money");
        console.writeLine("4) Convert money by exchange rate");
        console.writeLine("5) Quit");
    }

    private void chooseMenuItem() {
        int selection = console.readLine("Please enter a number to continue: ", Integer.class);
        console.writeLine();

        switch (selection) {
            case 1 -> cardPresenter.displayBalance();
            case 2 -> cardPresenter.addMoney();
            case 3 -> cardPresenter.withdrawMoney();
            case 4 -> cardPresenter.convertMoneyByExchangeRate();
            case 5 -> isAtmWork = false;
            default -> console.writeLine("Cannot find action");
        }
    }
}
