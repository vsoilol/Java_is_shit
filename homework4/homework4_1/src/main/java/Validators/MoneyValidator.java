package Validators;

public class MoneyValidator implements Validator<Double> {
    @Override
    public boolean isValid(Double value) {
        return value > 0;
    }
}
