import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Java8StatisticService implements StatisticService {
    @Override
    public long countEvenNumbers(List<Long> numbers) {
        return numbers.stream().filter(number -> number % 2 == 0).count();
    }

    @Override
    public List<Long> calculateSquareOfDistinctNumbers(List<Long> numbers) {
        return numbers.stream().sorted().map(number -> number * number).toList();
    }

    @Override
    public Map<Character, List<String>> groupStringsByLastLetter(Set<List<String>> strings) {
        return strings.stream()
                .flatMap(Collection::stream)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.groupingBy(s -> Character
                        .toUpperCase(s.charAt(s.length() - 1))));
    }
}
