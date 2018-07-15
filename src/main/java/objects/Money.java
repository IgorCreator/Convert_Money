package objects;
import operations.ActionExpression;

public class Money implements ActionExpression {

    int amount;
    protected String currency;

    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public Money(int amount, String currency){
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
     return new Money(amount + addend.amount, currency);
    }
}