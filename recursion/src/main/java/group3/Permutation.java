package group3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by U292148 on 2015.07.19..
 */
public class Permutation {

    public List<List<String>> permute(List<String> original) {
        return permute1(original);
    }

    private List<List<String>> permute1(List<String> original) {
        if (original == null || original.size() == 0) {
            return Collections.<List<String>>emptyList();
        }

        return myPermute(new ArrayList<String>(), original);
    }

    private List<List<String>> myPermute(List<String> selected, List<String> original) {

        if (selected.size() == original.size()) {
            //clone selected + create result
            List<List<String>> list = new ArrayList<>();
            list.add(new ArrayList<String>(selected));
            return list;
        }

        List<List<String >> myResult = new ArrayList<>();

        for (String  elem : original) {

            if (selected.contains(elem)) {
                continue;
            }

            selected.add(elem);
            List<List<String >> t = myPermute(selected, original);
            myResult.addAll(t);
            selected.remove(elem);
        }

        return myResult;
    }

}
