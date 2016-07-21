package powersets;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by u292148 on 2016.07.21..
 */
public class PowerSet {

    public Set<Set<Integer>> powerSet(Set<Integer> mySet) {

        if (mySet == null) {
            return null;
        }

        if (mySet.isEmpty()) {
            return createResult();
        }

        Set<Set<Integer>> result = new HashSet<>();
        result.add(mySet);

        mySet.forEach(item ->
                {
                    Set<Integer> newSet = new HashSet(mySet);
                    newSet.remove(item);
                    Set<Set<Integer>> partialResult = powerSet(newSet);
                    result.addAll(partialResult);
                }
        );

        return result;
    }

    private Set<Set<Integer>> createResult() {
        Set<Set<Integer>> q = new HashSet<>();
        q.add(Collections.emptySet());
        return q;
    }
}
