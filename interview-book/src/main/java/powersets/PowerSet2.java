package powersets;

import java.util.*;

/**
 * Created by hp21 on 2016.07.21..
 */
public class PowerSet2 implements IPowerSet {


    @Override
    public Set<List<Integer>> powerSet(List<Integer> mySet) {
        return powerSet(mySet, 0);
    }

    public Set<List<Integer>> powerSet(List<Integer> mySet, int level) {

        if (mySet == null) {
            return null;
        }

        if (mySet.isEmpty() || level == mySet.size()) {
            return createEmptyResult();
        }

        Set<List<Integer>> result = new HashSet<>();
        result.add(mySet.subList(level,mySet.size()));


        for (int i = level; i < mySet.size(); i++) {

            int temp;

            swap(mySet, level, i);

            Set<List<Integer>> partialResult = powerSet(mySet, level + 1);
            result.addAll(partialResult);

            swap(mySet, level, i);

        }


        return result;
    }

    private void swap(final List<Integer> mySet, final int level, final int i) {
        Integer temp;

        temp = mySet.get(i);
        mySet.set(i, mySet.get(level));
        mySet.set(level, temp);
    }

    private Set<List<Integer>> createEmptyResult() {
        HashSet<List<Integer>> result = new HashSet<>();
        result.add(Collections.emptyList());
        return result;
    }
}
