package Validators;

import Resources.ErrorMessages;

public class LetterInfoBuilderValidator implements Validator<String>{
    @Override
    public void check(String toCheck) {
        if(toCheck.length() == 0) {
            throw new IllegalArgumentException(ErrorMessages.LENGTH_CANNOT_BE_ZERO);
        }
    }
}
