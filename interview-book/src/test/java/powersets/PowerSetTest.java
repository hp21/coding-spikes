package powersets;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by u292148 on 2016.07.21..
 */
public class PowerSetTest {

    private PowerSet powerset;

    @Before
    public void setUp() throws Exception {
        powerset = new PowerSet();

    }

    @Test
    public void powerSetWithNull() throws Exception {

        Set<Set<Integer>> actual = powerset.<Integer>powerSet(null);
        assertThat(actual, CoreMatchers.nullValue());
    }

    @Test
    public void powerSetWithEmpty() throws Exception {

        Set<Set<Integer>> actual = powerset.powerSet(Collections.emptySet());
        assertThat(actual.size(), is(1));
    }

    @Test
    public void powerSetWithOneElement() throws Exception {

        Set<Integer> inp = new HashSet<>(Arrays.asList(2));

        Set<Set<Integer>> actual = powerset.powerSet(inp);
        assertThat(actual.size(), is(2));

        int elements0 = 0;
        int elements1 = 0;

        for (Set<Integer> a : actual) {
            elements0 = a.size() == 0 ? elements0 + 1 : elements0;
            elements1 = a.size() == 1 ? elements1 + 1 : elements1;
        }


        assertThat(elements0, is(1));
        assertThat(elements1, is(1));


        System.out.println("2: " + actual);
    }

    @Test
    public void powerSetWithTwoElement() throws Exception {

        Set<Integer> inp = new HashSet<>(Arrays.asList(2, 3));

        Set<Set<Integer>> actual = powerset.powerSet(inp);
        assertThat(actual.size(), is(4));

        int elements0 = 0;
        int elements1 = 0;
        int elements2 = 0;

        for (Set<Integer> a : actual) {
            elements0 = a.size() == 0 ? elements0 + 1 : elements0;
            elements1 = a.size() == 1 ? elements1 + 1 : elements1;
            elements2 = a.size() == 2 ? elements2 + 1 : elements2;
        }


        assertThat(elements0, is(1));
        assertThat(elements1, is(2));
        assertThat(elements2, is(1));


        System.out.println("2: " + actual);
    }


    @Test
    public void powerSetWith4Element() throws Exception {

        Set<Integer> inp = new HashSet<>(Arrays.asList(4, 5, 6, 7));

        Set<Set<Integer>> actual = powerset.powerSet(inp);
        assertThat(actual.size(), is(16));


        int elements0 = 0;
        int elements1 = 0;
        int elements2 = 0;
        int elements3 = 0;
        int elements4 = 0;

        for (Set<Integer> a : actual) {
            elements0 = a.size() == 0 ? elements0 + 1 : elements0;
            elements1 = a.size() == 1 ? elements1 + 1 : elements1;
            elements2 = a.size() == 2 ? elements2 + 1 : elements2;
            elements3 = a.size() == 3 ? elements3 + 1 : elements3;
            elements4 = a.size() == 4 ? elements4 + 1 : elements4;
        }


        assertThat(elements0, is(1));
        assertThat(elements1, is(4));
        assertThat(elements2, is(6));
        assertThat(elements3, is(4));
        assertThat(elements4, is(1));


        System.out.println("2: " + actual);
    }


}
