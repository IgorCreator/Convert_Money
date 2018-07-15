import objects.Money;
import operations.ActionExpression;
import operations.Bank;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoneyTest {

    @Test
    public void testDollarMultiplication(){
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testFrancMultiplication(){
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    public void testEquality(){
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.franc(5).equals(Money.franc(6)));

        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void testCurrency(){
        assertEquals("USD",Money.dollar(1).getCurrency());
        assertEquals("CHF",Money.franc(1).getCurrency());
    }

    @Test
    public void testDifferentClass(){
        assertEquals(new Money(5, "USD"),(new Money(5, "USD")));
    }

    @Test
    public void testSimpAdding(){
        Money five = Money.dollar(5);
        ActionExpression value = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.transform(value, "USD");
        assertEquals(Money.dollar(10), reduced);
    }
}