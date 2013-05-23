package recursion;

import static java.lang.Math.abs;

/**
 * Created with IntelliJ IDEA. User: u292148 Date: 2013.05.23. Time: 12:41 To
 * change this template use File | Settings | File Templates.
 */
public class Sum {
    /**
     * return the sum 1+ 2+ 3+ ...+ n
     */

    public int sum(int n) {
        int value;

        if (abs(n) <= 1) {
            value = n;
        } else {
            value = n + sum(predecessor(n));
        }

        return value;
    }

    private int predecessor(int n) {
        return n - Integer.signum(n);
    }

}
