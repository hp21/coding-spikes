package group3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by U292148 on 2015.07.19..
 */
public class Permutation {

    public static void main(String[] args) {
        new Permutation().run();
    }

    private void run() {

        ArrayList<Object> result = new ArrayList<Object>();

        permute(new ArrayList<Object>(), Arrays.<Object>asList("0", "1", "2"), result);
    }


    public List<Object> permute(List<Object> selected, List<Object> original, List<Object> result) {
        if (original == null || original.size() == 0) {
            result.clear();
            return result;
        }

        return myPermute(selected, original, result);
    }

    private List<Object> myPermute(List<Object> selected, List<Object> original, List<Object> result) {

        if (selected.size() == original.size()) {
            result.add(new ArrayList<>(selected));
        }

        for (Object elem : original) {

            if (selected.contains(elem)) {
                continue;
            }

            selected.add(elem);
            myPermute(selected, original, result);
            selected.remove(elem);
        }

        return result;
    }

}
