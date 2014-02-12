package other.a1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by hp21 on 2014.02.12..
 * 
 * http://thereq.com/q/1730/java-software-interview-question/sort-an-array-of-
 * strings-by-the-length-of-the-string
 */
public class StrSort {

    public String[] strSort(String[] strings) {

        if (strings == null) {
            return null;
        }

        Collections.sort(Arrays.asList(strings), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        return strings;
    }
}
