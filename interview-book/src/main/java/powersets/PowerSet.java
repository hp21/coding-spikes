package powersets;

import java.util.*;

import com.sun.javafx.collections.SetListenerHelper;

/**
 * Created by hp21 on 2016.07.21..
 */
public class PowerSet implements IPowerSet {


    @Override
    public Set<List<Integer>> powerSet(final List<Integer> mySet) {

       return powerSetInt(mySet);
    }

    public Set<List<Integer>> powerSetInt(List<Integer> mySet) {

        if (mySet == null) {
            return null;
        }

        if (mySet.isEmpty()) {
            return createEmptyResult();
        }

        Set<List<Integer>> result = new HashSet<>();
        result.add(mySet);

        mySet.forEach(item ->
                {
                    List<Integer> newSet = new ArrayList<>(mySet);
                    newSet.remove(item);
                    Set<List<Integer>> partialResult = powerSetInt(newSet);
                    result.addAll(partialResult);
                }
        );

        return result;
    }

    private Set<List<Integer>> createEmptyResult() {
        Set<List<Integer>> q = new HashSet<>();
        q.add(Collections.emptyList());
        return q;
    }
}
