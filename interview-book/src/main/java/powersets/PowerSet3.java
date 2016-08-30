package powersets;

import java.util.*;

import com.google.common.collect.ImmutableMap;

/**
 * Created by u292148 on 2016.08.30..
 */
public class PowerSet3 {

    public static void main(String[] args) {
        new PowerSet3().run();
    }

    private void run() {

        Set<List<String>> hplist = new PowerSet<String>().powerSet(Arrays.asList("a", "b", "c", "d", "d", "e", "f"));
        System.out.println(hplist);


/*
        Map<Integer, String> map = ImmutableMap.<Integer, String>builder().put(1, "a").put(2, "b").put(3, "c").put(4, "d").put(5, "e").put(6, "f").build();

        Set<List<Integer>> lists = new PowerSet().powerSetInt(new ArrayList<>(map.keySet()));

        Set<List<String>> mylist = new HashSet<>();

        for (List<Integer> a : lists) {
            List<String> strings = new ArrayList<>();
            a.forEach(q -> strings.add(map.get(q)));
            mylist.add(strings);
        }


        System.out.println(mylist);
*/


    }
}
