package operations;

import objects.Money;

public interface ActionExpression {
    Money reduce(Bank bank, String to);
}
