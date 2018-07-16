package operations;

import objects.Money;

public interface ActionExpression {
    Money reduce(String to);
}
