import Card.Card;
import Card.CreditCard;
import Card.DebitCard;

public class Main {
    public static void main(String[] args) {
        Card creditCard = new CreditCard("User Credit");
        Card debitCard = new DebitCard("User Debit");

        ATM atm = new ATM();
        atm.run(debitCard);
    }
}
