import Card.CreditCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardTests {
    private CreditCard creditCard;

    @BeforeEach
    public void init() {
        this.creditCard = new CreditCard("Vlad", BigDecimal.valueOf(50));
    }

    @Test
    public void testAddMoneyToBalanceShouldWorkAsExpected() {
        creditCard.addMoneyToBalance(BigDecimal.valueOf(100.9541512));
        BigDecimal actual = creditCard.getBalance();

        BigDecimal expected = BigDecimal.valueOf(150.9541512);

        assertEquals(expected, actual);
    }

    @Test
    public void testWithdrawMoneyFromShouldWorkAsExpected() {
        creditCard.withdrawMoneyFrom(BigDecimal.valueOf(40.68471542));
        BigDecimal actual = creditCard.getBalance();

        BigDecimal expected = BigDecimal.valueOf(9.31528458);

        assertEquals(expected, actual);
    }

    @Test
    public void testWithdrawMoneyFromShouldWorkIfBalanceLessThanMoney() {
        creditCard.withdrawMoneyFrom(BigDecimal.valueOf(50.68471542));
        BigDecimal actual = creditCard.getBalance();

        BigDecimal expected = BigDecimal.valueOf(-0.68471542);

        assertEquals(expected, actual);
    }

    @Test
    public void testConvertMoneyByExchangeRateShouldWorkAsExpected() {
        BigDecimal actual = creditCard.convertMoneyByExchangeRate(1.2);

        BigDecimal expected = BigDecimal.valueOf(60.0);

        assertEquals(expected, actual);
    }
}
