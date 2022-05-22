import java.util.Comparator;

public class IntegerArrayComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer number1, Integer number2) {
        return sumOfDigits(number1).compareTo(sumOfDigits(number2));
    }

    private Integer sumOfDigits(int number) {
        return String.valueOf(number)
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }
}
