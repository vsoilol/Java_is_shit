public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Card card = new Card("User");

        atm.run(card);
    }
}
