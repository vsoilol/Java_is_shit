package LetterInfo;

import java.util.*;
import java.util.stream.Collectors;

public class LetterInfoService {
    public ArrayList<LetterInfo> createLettersInfoByText(String text) {
        ArrayList<LetterInfo> lettersInfo = new ArrayList<LetterInfo>();
        String[] words = text.split("[\\p{Punct}\\s1-9]+");

        Map<String, Long> wordsInfo = Arrays.asList(words)
                .stream()
                .collect(Collectors.groupingBy(s -> s.toLowerCase().replaceAll("\\d", ""), Collectors.counting()));

        for (var word : wordsInfo.entrySet()) {
            Character newLetter = word.getKey().charAt(0);

            LetterInfo letterInfo = lettersInfo.stream()
                    .filter(letter -> letter.getLetter() == newLetter)
                    .findAny()
                    .orElse(null);

            if (letterInfo != null) {
                letterInfo.putWord(word.getKey(), word.getValue().intValue());
            } else {
                lettersInfo.add(new LetterInfo(word.getKey(), word.getValue().intValue()));
            }
        }

        return lettersInfo;
    }

    public String getLettersInfoView(ArrayList<LetterInfo> lettersInfo) {
        StringBuilder stringBuilder = new StringBuilder();
        Collections.sort(lettersInfo);

        for (LetterInfo letterInfo : lettersInfo) {
            stringBuilder.append(letterInfo.getLetter().toString().toUpperCase()).append(":");
            stringBuilder.append(getWordsInfoView(letterInfo));
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    private String getWordsInfoView(LetterInfo letterInfo) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, Integer> word : letterInfo.getWords().entrySet()) {
            stringBuilder.append("\t");
            stringBuilder.append(word.getKey()).append(" ").append(word.getValue());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
