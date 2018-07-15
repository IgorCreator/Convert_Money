class Money {

    int amount;
    protected String currency;

    Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object obj){
        Money money = (Money)obj;
        return amount == money.amount && getCurrency().equals(money.getCurrency());
    }

    static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

    public Money plus(Money addend) {
     return new Money(amount + addend.amount, currency);
    }
}