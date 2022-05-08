import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {
    private Card card;

    @BeforeEach
    public void init() {
        this.card = new Card("Vlad", BigDecimal.valueOf(50));
    }

    @Test
    public void testAddMoneyToBalanceShouldWorkAsExpected() {
        card.addMoneyToBalance(BigDecimal.valueOf(100.9541512));
        BigDecimal actual = card.getBalance();

        BigDecimal expected = BigDecimal.valueOf(150.9541512);

        assertEquals(expected, actual);
    }

    @Test
    public void testWithdrawMoneyFromShouldWorkAsExpected() {
        card.withdrawMoneyFrom(BigDecimal.valueOf(40.68471542));
        BigDecimal actual = card.getBalance();

        BigDecimal expected = BigDecimal.valueOf(9.31528458);

        assertEquals(expected, actual);
    }

    @Test
    public void testWithdrawMoneyFromShouldThrowNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> card.withdrawMoneyFrom(BigDecimal.valueOf(50.68471542)));
    }

    @Test
    public void testConvertMoneyByExchangeRateShouldWorkAsExpected() {
        BigDecimal actual = card.convertMoneyByExchangeRate(1.2);

        BigDecimal expected = BigDecimal.valueOf(60.0);

        assertEquals(expected, actual);
    }
}
