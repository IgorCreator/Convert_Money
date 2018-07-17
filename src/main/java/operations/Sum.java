package operations;

import objects.Money;

public class Sum implements ActionExpression{

    public ActionExpression augend;
    public ActionExpression addend;

    public Sum(ActionExpression augend, ActionExpression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String to) {
        int amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount;
        return new Money(amount,to);
    }

    public ActionExpression plus(ActionExpression addend) {
        return new Sum(this, addend);
    }

    public ActionExpression times(int multip) {
        return new Sum(augend.times(multip), addend.times(multip));
    }
}
