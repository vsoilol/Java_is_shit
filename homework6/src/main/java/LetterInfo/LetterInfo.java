package LetterInfo;

import java.util.*;

public class LetterInfo implements Comparable<LetterInfo> {
    private final Character letter;
    private final Map<String, Integer> words;

    public LetterInfo(String word, int count) {
        words = new HashMap<>();
        letter = word.toLowerCase().charAt(0);
        words.put(word, count);
    }

    public void putWord(String word, int count) {
        words.put(word.toLowerCase(), count);
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
