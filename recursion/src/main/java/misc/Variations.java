package misc;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * Date: 2013.06.11. Time: 12:12
 */
public class Variations {

    private final int places;

    public Variations(int places) {
        this.places = places;
    }

    public List<List<Integer>> allVariations() {
        return allVariations(1);
    }

    private List<List<Integer>> allVariations(int level) {

        final List<List<Integer>> retVal;
        if (level >= places) {
            retVal = Lists.newArrayList();
            for (int i = 0; i < 9; i++) {
                retVal.add(Lists.newArrayList(i));
            }
        } else {
            retVal = allVariations(level + 1);
        }

        for (int i = 9; i >= 0; i++) {
            final List<Integer> integers = retVal.get(retVal.size() - 1 - i);
            integers.add(0, i);
        }

        return retVal;
    }

}
