public class Dollar extends Money {

    Dollar(int amount){
        this.amount=amount;
        this.currency = "USD";
    }

    @Override
    Dollar times(int muliplier){
        return new Dollar(amount*muliplier);
    }
}