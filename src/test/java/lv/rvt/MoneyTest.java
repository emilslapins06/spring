package lv.rvt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import rvt.Money;

public class MoneyTest {

    @Test
    public void testPlusMethod() {
        Money mon1 = new Money(1, 85);
        Money mon2 = new Money(2, 90);

        Money result1 = mon1.plus(mon2);

        assertEquals(4, result1.euros());
        assertEquals(74, result1.cents());

    }

    @Test
    public void testLessThan() {
        Money mon1 = new Money(2, 80);
        Money mon2 = new Money(2, 90);
        Money mon3 = new Money(5, 00);

        boolean result1 = mon1.lessThan(mon2);
        boolean result2 = mon3.lessThan(mon1);

        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    public void testMinusMethod() {
        Money mon1 = new Money(2, 80);
        Money mon2 = new Money(2, 80);

        Money result1 = mon1.minus(mon2);

        assertEquals(0, result1.euros());
        assertEquals(0, result1.cents());
    }

    @Test
    public void isMoneyEqual() {
        Money mon1 = new Money(5, 50);
        Money mon2 = new Money(5, 50);
        assertEquals(mon1, mon2);
    }

}