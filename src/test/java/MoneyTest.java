import objects.Franc;
import objects.Money;
import operations.ActionExpression;
import operations.Bank;
import operations.Sum;
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

    @Test
    public void plusReturnsSum(){
        Money five = Money.dollar(5);
        ActionExpression value = five.plus(five);
        Sum sum = (Sum) value;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    public void testTransformSum(){
        ActionExpression value = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money res = bank.transform(value, "USD");
        assertEquals(Money.dollar(7), res);
    }

    @Test
    public void testIdentityRate(){
        assertEquals(1, new Bank().rate("USD", "USD"));
    }

    @Test
    public void testReduceMoneyDifferentCurrency(){
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money res = bank.transform(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), res);
    }

    @Test
    public void testMixedAddition(){
        ActionExpression fiveBucks = Money.dollar(5);
        ActionExpression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money res = bank.transform((fiveBucks).plus(tenFrancs), "USD");
        assertEquals(Money.dollar(10), res);
    }

    @Test
    public void testSumPlusMoney(){
        ActionExpression fiveBucks = Money.dollar(5);
        ActionExpression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        ActionExpression sum = new Sum(fiveBucks, tenFrancs).times(2);
        Money res = bank.transform(sum, "USD");
        assertEquals(Money.dollar(20), res);
    }

    @Test
    public void testPlusSameCurrency(){
        ActionExpression sum = Money.dollar(2).plus(Money.dollar(2));
        assertTrue(sum instanceof Money);
    }
}