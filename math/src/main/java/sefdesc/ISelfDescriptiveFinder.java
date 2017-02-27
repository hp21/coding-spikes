package sefdesc;

import java.util.List;

/**
 * Created by HP21 on 2017-02-24.
 * <p>
 * See: https://rosettacode.org/wiki/Self-describing_numbers
 * See: https://en.wikipedia.org/wiki/Self-descriptive_number
 * <p>
 * An integer is said to be "self-describing" if it has the property that, when digit positions are labeled 0 to N-1, the digit in each position is equal to the number of times that that digit appears in the number.
 * <p>
 * For example,   2020   is a four-digit self describing number:
 * <p>
 * position   0   has value   2   and there are two 0s in the number;
 * position   1   has value   0   and there are no 1s in the number;
 * position   2   has value   2   and there are two 2s;
 * position   3   has value   0   and there are zero 3s.
 * <p>
 * Most significant digit in the number has 0 (zero) index
 */
public interface ISelfDescriptiveFinder {

    List<Long> find( int base );

}
