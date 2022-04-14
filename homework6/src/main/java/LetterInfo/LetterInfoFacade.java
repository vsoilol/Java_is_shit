package LetterInfo;

import Validators.LetterInfoBuilderValidator;
import Validators.LetterInfoViewValidator;

import java.util.ArrayList;

public class LetterInfoFacade {
    public void printLettersInfoByText(String text){
        LetterInfoBuilderValidator builderValidator = new LetterInfoBuilderValidator();
        LetterInfoViewValidator viewValidator = new LetterInfoViewValidator();

        LetterInfoBuilder builder = new LetterInfoBuilder(builderValidator);
        LetterInfoView view = new LetterInfoView(viewValidator);

        ArrayList<LetterInfo> lettersInfo = builder.createLettersInfoByText(text);

        System.out.println(view.getLettersInfoView(lettersInfo));
    }
}
