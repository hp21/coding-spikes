package powersets;

import java.util.*;

/**
 * Created by hp21 on 2016.07.21..
 */
public class PowerSet<T> implements IPowerSet<T> {


    @Override
    public Set<List<T>> powerSet(final List<T> mySet) {

        return powerSetInt(mySet);
    }

    public Set<List<T>> powerSetInt(List<T> mySet) {

        if (mySet == null) {
            return null;
        }

        if (mySet.isEmpty()) {
            return createEmptyResult();
        }

        Set<List<T>> result = new HashSet<>();
        result.add(mySet);

        mySet.forEach(item ->
                {
                    List<T> newSet = new ArrayList<>(mySet);
                    newSet.remove(item);
                    Set<List<T>> partialResult = powerSetInt(newSet);
                    result.addAll(partialResult);
                }
        );

        return result;
    }

    private Set<List<T>> createEmptyResult() {
        Set<List<T>> q = new HashSet<>();
        q.add(Collections.emptyList());
        return q;
    }
}
