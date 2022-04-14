package LetterInfo;

import com.google.common.annotations.VisibleForTesting;

import java.util.HashMap;
import java.util.Map;

public class LetterInfo implements Comparable<LetterInfo>{
    private final Character letter;
    private final Map<String, Integer> words;

    public LetterInfo(String word){
        words = new HashMap<String, Integer>();
        letter = word.charAt(0);
        words.put(word, 1);
    }

    @VisibleForTesting
    public LetterInfo(String word, Integer amount) {
        words = new HashMap<String, Integer>();
        letter = word.charAt(0);
        words.put(word, amount);
    }

    public void putWord(String word){
        if(words.containsKey(word)){
            words.put(word, words.get(word) + 1);
        }
        else {
            words.put(word, 1);
        }
    }

    public Character getLetter() {
        return letter;
    }

    public Map<String, Integer> getWords() {
        return words;
    }

    @Override
    public int compareTo(LetterInfo o) {
        return letter.compareTo(o.letter);
    }
}
