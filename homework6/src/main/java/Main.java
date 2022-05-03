import LetterInfo.LetterInfoFacade;

public class Main {
    public static void main(String[] args) {
        String text = "Once upon a time 11!    5423_)(*&^%$#()_ a Wolf was lapping at a spring on a hillside, when, looking up, what should he see but a Lamb just beginning to drink a little lower down.";

        LetterInfoFacade facade = new LetterInfoFacade();
        facade.printLettersInfoByText(text);
    }
}
