package spike.partorder;

/**
 * Hello world!
 */
public class Pair<T extends Comparable> {
    private T first;
    private T second;




    public Pair(final T first, final T second) {
        this.first = first;
        this.second = second;

        if (!isLowerEqual()) {
            throw new RuntimeException(String.format("First: %s, second: %s, not lowereq", first.toString(), second.toString()));
        }
    }

    public boolean isLower() {
        return first.compareTo(second) < 0;

    }

    public boolean isLowerEqual() {
        return first.compareTo(second) <= 0;
    }


    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
