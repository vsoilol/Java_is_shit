package LetterInfo;

import Resources.RegularExpressions;
import Validators.Validator;

import java.util.ArrayList;

public class LetterInfoBuilder {
    private final Validator<String> validator;

    public LetterInfoBuilder(Validator<String> validator) {
        this.validator = validator;
    }

    public ArrayList<LetterInfo> createLettersInfoByText(String text){
        validator.check(text);

        ArrayList<LetterInfo> lettersInfo = new ArrayList<LetterInfo>();
        String[] words = text.split(RegularExpressions.WORDS_SPLIT);

        for (String word:words){
            String newWord = word.toLowerCase();
            Character newLetter = newWord.charAt(0);

            LetterInfo letterInfo = lettersInfo.stream()
                    .filter(letter -> letter.getLetter() == newLetter)
                    .findAny()
                    .orElse(null);

            if(letterInfo != null){
                letterInfo.putWord(newWord);
            }
            else {
                lettersInfo.add(new LetterInfo(newWord));
            }
        }

        return lettersInfo;
    }
}
