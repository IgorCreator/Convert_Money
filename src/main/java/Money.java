abstract class Money {

    int amount;
    String currency;

    abstract Money times(int muliplier);

    @Override
    public boolean equals(Object obj){
        return amount == ((Money)obj).amount && getClass().equals(obj.getClass());
    }

    static Money dollar(int amount) {
        return new Dollar(amount);
    }

    static Money franc(int amount) {
        return new Franc(amount);
    }


}