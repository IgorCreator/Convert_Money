public class Franc extends Money {

    Franc(int amount){
        this.amount=amount;
        this.currency = "CHF";
    }

    @Override
    Franc times(int muliplier){
        return new Franc(amount*muliplier);
    }
}