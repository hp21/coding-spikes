package spike.partorder;

/**
 * Created with IntelliJ IDEA. User: hp21 Date: 2013.03.04. Time: 9:31 To
 * change this template use File | Settings | File Templates.
 */
public class CompartmentSupport {

    private final int numberOfCompartments;
    private final int bigger;
    private final int smaller;

    public CompartmentSupport(int numberOfCompartments, int bigger, int smaller) {

        this.numberOfCompartments = numberOfCompartments;
        this.bigger = bigger;
        this.smaller = smaller;
    }

    public int computeCompartment(int seat) {
        if (seat < 0 || seat > (numberOfCompartments * bigger + numberOfCompartments * smaller)) {
            throw new IllegalArgumentException("Invalid seat number");
        }

        if (seat <= numberOfCompartments * bigger) {
            return ((seat - 1) / bigger) + 1;
        }

        // TODO: Finish
        return 9 - (seat - numberOfCompartments * bigger - 1) / smaller;

    }

    public int variations(int max, int paxnumber) {

        return factorial(max) / (factorial(paxnumber) * factorial(max - paxnumber));
    }

    private int factorial(int n) {
        if (n <= 0)
            return 1;
        else
            return n * factorial(n - 1);
    }
}
