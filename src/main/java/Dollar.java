public class Dollar extends Money {

    Dollar(int amount){
        this.amount=amount;
        this.currency = "USD";
    }

    Dollar times(int muliplier){
        return new Dollar(amount*muliplier);
    }

    @Override
    public boolean equals(Object obj){
        return amount == ((Dollar)obj).amount;
    }
}