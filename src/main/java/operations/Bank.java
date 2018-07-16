package operations;

import objects.Money;

public class Bank {

    public Money transform(ActionExpression source, String to) {
        return source.reduce(to);
    }
}
