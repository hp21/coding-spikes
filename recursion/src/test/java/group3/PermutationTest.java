package group3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by U292148 on 2015.07.19..
 */
public class PermutationTest {

    private Permutation permutation;

    @Before
    public void setUp() {
        permutation = new Permutation();
    }

    @Test
    public void testWithEmptyInput() throws Exception {

        List<List<String>> actual = permutation.permute(Arrays.<String>asList());

        assertThat(actual.size(), is(0));
    }

    @Test
    public void testWithOneElementInput() throws Exception {

        List<String> selected = new ArrayList<>();
        List<List<String>> actual = permutation.permute(Arrays.<String>asList("1"));

        assertThat(actual.size(), is(1));

        dumpResult(actual);
    }

    @Test
    public void testWithTwoElementInput() throws Exception {

        List<String> selected = new ArrayList<>();
        List<List<String>> actual = permutation.permute(Arrays.<String>asList("1", "2"));

        assertThat(actual.size(), is(2));

        dumpResult(actual);
    }

    @Test
    public void testWith3ElementInput() throws Exception {

        ArrayList<String> selected = new ArrayList<>();
        List<List<String>> actual = permutation.permute(Arrays.<String>asList("1", "2", "3"));

        assertThat(actual.size(), is(6));

        dumpResult(actual);
    }

    @Test
    public void testWith4ElementInput() throws Exception {

        List<String> selected = new ArrayList<>();
        List<List<String>> actual = permutation.permute(Arrays.<String>asList("1", "2", "3", "4"));

        assertThat(actual.size(), is(24));

        dumpResult(actual);
    }

    @Test
    public void testWith5ElementInput() throws Exception {

        List<String > selected = new ArrayList<>();
        List<List<String> > actual = permutation.permute(Arrays.<String >asList("1", "2", "3", "4", "5"));

        assertThat(actual.size(), is(120));

        dumpResult(actual);
    }


    private void dumpResult(List<List<String>> result) {
        for (Object item : result) {
            System.out.print(item);
        }

        System.out.println("##");

    }
}
