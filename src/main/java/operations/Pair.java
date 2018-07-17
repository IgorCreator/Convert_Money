package operations;

public class Pair {
    private String from;
    private String to;

    Pair(String from, String to){
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        Pair pair = (Pair) o;
        return from.equals(pair.from) && to.equals(to);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
