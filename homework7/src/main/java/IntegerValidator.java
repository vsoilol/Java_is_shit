public class IntegerValidator implements Validator<Integer> {
    @Override
    public boolean isValid(Integer value) {
        return value >= 1 && value <= 10;
    }
}
