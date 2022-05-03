package Validators;

import LetterInfo.LetterInfo;
import Resources.ErrorMessages;

import java.util.ArrayList;

public class LetterInfoViewValidator implements Validator<ArrayList<LetterInfo>>{
    @Override
    public void check(ArrayList<LetterInfo> toCheck) {
        if(toCheck.size() == 0){
            throw new IllegalArgumentException(ErrorMessages.ARRAY_SHOULD_HAVE_ONE_ELEMENT);
        }
    }
}
