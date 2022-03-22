import Card.DebitCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DebitCardTests {
    private DebitCard debitCard;

    @BeforeEach
    public void init() {
        this.debitCard = new DebitCard("Vlad", BigDecimal.valueOf(50));
    }

    @Test
    public void testAddMoneyToBalanceShouldWorkAsExpected() {
        debitCard.addMoneyToBalance(BigDecimal.valueOf(100.9541512));
        BigDecimal actual = debitCard.getBalance();

        BigDecimal expected = BigDecimal.valueOf(150.9541512);

        assertEquals(expected, actual);
    }

    @Test
    public void testWithdrawMoneyFromShouldWorkAsExpected() {
        debitCard.withdrawMoneyFrom(BigDecimal.valueOf(40.68471542));
        BigDecimal actual = debitCard.getBalance();

        BigDecimal expected = BigDecimal.valueOf(9.31528458);

        assertEquals(expected, actual);
    }

    @Test
    public void testWithdrawMoneyFromShouldThrowNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> debitCard.withdrawMoneyFrom(BigDecimal.valueOf(50.68471542)));
    }

    @Test
    public void testConvertMoneyByExchangeRateShouldWorkAsExpected() {
        BigDecimal actual = debitCard.convertMoneyByExchangeRate(1.2);

        BigDecimal expected = BigDecimal.valueOf(60.0);

        assertEquals(expected, actual);
    }
}
