package nfa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created User: Peter Horvath/u292148
 * Date: 2013.07.07. Time: 9:27
 */
public class SetCreator {

    public static <T> Set<T> create(T... values) {
        return new HashSet<T>(Arrays.asList(values));
    }
}
