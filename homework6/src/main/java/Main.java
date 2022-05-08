import LetterInfo.LetterInfo;
import LetterInfo.LetterInfoService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String text = "Once upon a time a Wolf was lapping at a spring on a hillside, see but a Lamb just beginning to drink a little lower down.";

        LetterInfoService letterInfoService = new LetterInfoService();

        ArrayList<LetterInfo> lettersInfo = letterInfoService.createLettersInfoByText(text);
        System.out.println(letterInfoService.getLettersInfoView(lettersInfo));
    }
}
