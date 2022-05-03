package Validators;

import java.math.BigDecimal;

public class ExchangeRateValidator implements Validator<BigDecimal> {
    @Override
    public boolean isValid(BigDecimal money) {
        return money.compareTo(BigDecimal.valueOf(0)) == 1;
    }
}
