package powersets;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by hp21 on 2016.07.21..
 */
public class PowerSet2<T> implements IPowerSet<T> {


    @Override
    public Set<List<T>> powerSet(List<T> mySet) {
        return powerSet(mySet, 0);
    }

    public Set<List<T>> powerSet(List<T> mySet, int level) {

        if (mySet == null) {
            return null;
        }

        if (mySet.isEmpty() || level == mySet.size()) {
            return createEmptyResult();
        }

        Set<List<T>> result = new HashSet<>();
        result.add(mySet.subList(level, mySet.size()));


        for (int i = level; i < mySet.size(); i++) {

            int temp;

            swap(mySet, level, i);

            Set<List<T>> partialResult = powerSet(mySet, level + 1);
            result.addAll(partialResult);

            swap(mySet, level, i);

        }


        return result;
    }

    private void swap(final List<T> mySet, final int level, final int i) {
        T temp;

        temp = mySet.get(i);
        mySet.set(i, mySet.get(level));
        mySet.set(level, temp);
    }

    private Set<List<T>> createEmptyResult() {
        HashSet<List<T>> result = new HashSet<>();
        result.add(Collections.emptyList());
        return result;
    }
}
