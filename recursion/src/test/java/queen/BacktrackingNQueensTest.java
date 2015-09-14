package queen;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by U292148 on 2015.09.14..
 */
public class BacktrackingNQueensTest {

    private BacktrackingNQueens queen;

    @Before
    public void setUp() {
        queen = new BacktrackingNQueens();
        queen.state = queen.createState(8);
    }


    @Test
    public void promosing_0_test() {

        boolean actual = queen.promising(0);
        assertThat(actual, is(true));
    }


    @Test
    public void promosing_0_with_1_test() {

        for (int i = 0; i < queen.state.size(); i++) {
            queen.state.set(0, i);
            boolean actual = queen.promising(0);
            assertThat(actual, is(true));
        }
    }

    @Test
    public void promosing_1_conflict_test() {

        queen.state.set(0, 0);

        List<Integer> conflicts = Arrays.asList(0, 1);
        for (int i = 0; i < conflicts.size(); i++) {

            queen.state.set(1, i);
            boolean actual = queen.promising(1);
            assertThat(actual, is(false));
        }

        for (int i = 0; i < queen.state.size(); i++) {
            queen.state.set(0, 0);
        }

        List<Integer> oks = Arrays.asList(2, 3, 4, 5, 6, 7);
        for (int i = 0; i < oks.size(); i++) {

            queen.state.set(1, oks.get(i));
            boolean actual = queen.promising(1);
            assertThat(actual, is(true));
        }
    }


    @Test
    public void promosing_2_conflict_test1() {

        queen.state.set(0, 0);
        queen.state.set(1, 0);

        boolean actual = queen.promising(1);
        assertThat(actual, is(false));


    }

    @Test
    public void promosing_2_conflict_test2() {

        queen.state.set(0, 0);
        queen.state.set(1, 2);

        queen.state.set(2, 0);

        boolean actual = queen.promising(2);
        assertThat(actual, is(false));


    }

    @Test
    public void promosing_2_conflict_test3() {

        queen.state.set(0, 0);
        queen.state.set(1, 2);

        queen.state.set(2, 3);

        boolean actual = queen.promising(2);
        assertThat(actual, is(false));

    }


    @Test
    public void promosing_2_conflict_test4() {

        queen.state.set(0, 0);
        queen.state.set(1, 2);

        queen.state.set(2, 4);

        boolean actual = queen.promising(2);
        assertThat(actual, is(true));

    }


}