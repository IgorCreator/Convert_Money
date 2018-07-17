package objects;

import operations.ActionExpression;
import operations.Bank;
import operations.Sum;

public class Money implements ActionExpression {

    public int amount;
    protected String currency;

    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object obj){
        Money money = (Money)obj;
        return amount == money.amount && getCurrency().equals(money.getCurrency());
    }

    public static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

    public ActionExpression plus(Money addend) {
     return new Sum(this, addend);
    }

    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount/rate, to);
    }
}