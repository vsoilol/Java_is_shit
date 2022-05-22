import java.util.*;

public class Java7StatisticService implements StatisticService {
    @Override
    public long countEvenNumbers(List<Long> numbers) {
        long evenNumbersCount = 0;

        for (Long number : numbers) {
            if (number % 2 == 0) {
                evenNumbersCount++;
            }
        }

        return evenNumbersCount;
    }

    @Override
    public List<Long> calculateSquareOfDistinctNumbers(List<Long> numbers) {
        List<Long> sortedArray = sort(numbers);

        for (int i = 0; i < sortedArray.size(); i++) {
            sortedArray.set(i, sortedArray.get(i) * sortedArray.get(i));
        }

        return sortedArray;
    }

    @Override
    public Map<Character, List<String>> groupStringsByLastLetter(Set<List<String>> strings) {
        List<String> words = convertSetToList(strings);

        Map<Character, List<String>> result = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }

            Character lastLetter = Character.toUpperCase(word.charAt(word.length() - 1));

            List<String> letterWords;

            if (result.containsKey(lastLetter)) {
                letterWords = result.get(lastLetter);
            } else {
                letterWords = new ArrayList<>();
            }

            letterWords.add(word);
            result.put(lastLetter, letterWords);
        }

        return result;
    }

    private List<String> convertSetToList(Set<List<String>> strings) {
        List<String> result = new ArrayList<>();

        for (List<String> words : strings) {
            result.addAll(words);
        }

        return result;
    }

    private List<Long> sort(List<Long> array) {
        List<Long> sortedArray = new ArrayList<>(array);

        int n = sortedArray.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedArray.get(j) > sortedArray.get(j + 1)) {
                    long temp = sortedArray.get(j);
                    sortedArray.set(j, sortedArray.get(j + 1));
                    sortedArray.set(j + 1, temp);
                }
            }
        }

        return sortedArray;
    }
}
