package operations;

import objects.Money;

import java.util.Hashtable;

public class Bank {

    private Hashtable rates = new Hashtable();

    public Money transform(ActionExpression source, String to) {
        return source.reduce(this, to);
    }

    public void addRate(String transformFrom, String transformTo, int rate) {
        rates.put(new Pair(transformFrom, transformTo), rate);
    }

    public int rate(String from, String to){
        if (from.equals(to)) return 1;
        Integer rate = (Integer) rates.get(new Pair(from, to));
        return rate.intValue();
    }
}
