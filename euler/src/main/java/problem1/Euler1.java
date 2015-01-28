package problem1;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hp21 on 2015.01.28..
 * <p/>
 * <p/>
 * https://projecteuler.net/problem=1
 * <p/>
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */

public class Euler1 {


    private List<Long> differences = Arrays.asList(3L, 2L, 1L, 3L, 1L, 2L, 3L);

    public long createSum(long maxNum) {

        long sum = 0;

        long current = 0;

        for (long i = 0; true; i++) {

            current = current + differences.get((int) (i % differences.size()));

            if (current > maxNum) {
                break;
            }

            sum = sum + current;
        }

        return sum;

    }
}
