package LetterInfo;

import Validators.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class LetterInfoView {
    private final Validator<ArrayList<LetterInfo>> validator;

    public LetterInfoView(Validator<ArrayList<LetterInfo>> validator) {
        this.validator = validator;
    }

    public String getLettersInfoView(ArrayList<LetterInfo> lettersInfo){
        validator.check(lettersInfo);

        StringBuilder stringBuilder = new StringBuilder();
        Collections.sort(lettersInfo);

        for (LetterInfo letterInfo:lettersInfo){
            stringBuilder.append(letterInfo.getLetter().toString().toUpperCase()).append(":");
            stringBuilder.append(getWordsInfoView(letterInfo));
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    private String getWordsInfoView(LetterInfo letterInfo){
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, Integer> word : letterInfo.getWords().entrySet()) {
            stringBuilder.append("\t");
            stringBuilder.append(word.getKey()).append(" ").append(word.getValue());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
