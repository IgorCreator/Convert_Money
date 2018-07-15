abstract class Money {

    int amount;
    String currency;

    @Override
    public boolean equals(Object obj){
        return amount == ((Money)obj).amount && getClass().equals(obj.getClass());
    }


}