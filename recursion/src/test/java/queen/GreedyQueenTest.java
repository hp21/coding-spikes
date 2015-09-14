package queen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by U292148 on 2015.09.08..
 */
public class GreedyQueenTest {

    private GreedyQueen solver;

    @Before
    public void setUp() throws Exception {
        solver = new GreedyQueen();
    }

    @Test
    public void testThereAreConflicst() throws Exception {

    }

    @Test
    public void testSwap() throws Exception {

    }

    @Test
    public void testConflicts() throws Exception {

        List<String> state = Arrays.asList("0", "1");
        int actual = solver.conflicts(state);

        assertThat(actual, is(1));


    }

    @Test
    public void testConflicts0123() throws Exception {

        List<String> state = Arrays.asList("0", "1", "2", "3");
        int actual = solver.conflicts(state);

        assertThat(actual, is(6));


    }


    @Test
    public void testConflicts3() throws Exception {

        List<String> state = Arrays.asList("0", "1", "2");
        int actual = solver.conflicts(state);

        assertThat(actual, is(3));


    }

    @Test
    public void testConflicts10() throws Exception {

        List<String> state = Arrays.asList("5", "3", "1", "7", "2", "8", "6", "4", "9", "0");
        int actual = solver.conflicts(state);

        assertThat(actual, is(0));


    }

    @Test
    public void testConflictsForSolutions() throws Exception {

        ArrayList<List<String>> toBeChecked = new ArrayList<>();

        addToList(toBeChecked, 1, 3, 0, 2);
        addToList(toBeChecked, 2, 0, 3, 1);
        addToList(toBeChecked, 0, 2, 5, 8, 6, 9, 3, 1, 7);
        addToList(toBeChecked, 2, 7, 3, 8, 0, 5, 9, 6, 1);
        addToList(toBeChecked, 89, 42, 80, 78, 48, 36, 66, 10, 1, 88, 98, 12, 81, 70, 25, 7, 84, 43, 61, 31, 90, 57, 32, 41, 97, 44, 51, 18, 63, 91, 29, 11, 52, 30, 3, 72, 50, 92, 87, 73, 94, 65, 19, 71, 83, 68, 5, 64, 27, 56, 23, 45, 40, 15, 2, 0, 6, 46, 16, 8, 34, 77, 9, 76, 35, 22, 4, 13, 20, 59, 54, 86, 93, 58, 82, 79, 74, 21, 17, 39, 67, 49, 37, 69, 38, 85, 95, 14, 53, 55, 96, 26, 24, 60, 99, 28, 47, 75, 62, 33);

        for (List<String> strList : toBeChecked) {
            int conflicts = solver.conflicts(strList);
            assertThat("coflict: " + strList, conflicts, is(0));
        }
    }

    private void addToList(ArrayList<List<String>> toBeChecked, Integer... mylist) {
        List<Integer> intList = Arrays.asList(mylist);
        ArrayList<String> stringList = convertIntListToStringList(intList);
        toBeChecked.add(stringList);
    }

    private ArrayList<String> convertIntListToStringList(List<Integer> intList) {
        ArrayList<String> stringList = new ArrayList<>();

        for (Integer k : intList) {
            stringList.add("" + k);
        }
        return stringList;
    }


}