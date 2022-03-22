import Card.Card;
import Card.CreditCard;
import Card.DebitCard;

public class Main {
    public static void main(String[] args) {
        Card creditCard = new CreditCard("Vlad Credit");
        Card debitCard = new DebitCard("Vlad Debit");

        ATM atm = new ATM();
        atm.run(creditCard);
    }
}
