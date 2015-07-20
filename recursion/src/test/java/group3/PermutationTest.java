package group3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

        ArrayList<Object> result = new ArrayList<Object>();
        permutation.permute(Collections.emptyList(), Arrays.<Object>asList(), result);

        assertThat(result.size(), is(0));


    }

    @Test
    public void testWithOneElementInput() throws Exception {

        ArrayList<Object> result = new ArrayList<Object>();
        ArrayList<Object> selected = new ArrayList<>();
        permutation.permute(selected, Arrays.<Object>asList("1"), result);

        assertThat(result.size(), is(1));

        dumpResult(result);
    }

    @Test
    public void testWithTwoElementInput() throws Exception {

        ArrayList<Object> result = new ArrayList<Object>();
        ArrayList<Object> selected = new ArrayList<>();
        permutation.permute(selected, Arrays.<Object>asList("1", "2"), result);

        assertThat(result.size(), is(2));

        dumpResult(result);
    }

    @Test
    public void testWith3ElementInput() throws Exception {

        ArrayList<Object> result = new ArrayList<Object>();
        ArrayList<Object> selected = new ArrayList<>();
        permutation.permute(selected, Arrays.<Object>asList("1", "2", "3"), result);

        assertThat(result.size(), is(6));

        dumpResult(result);
    }

    @Test
    public void testWith4ElementInput() throws Exception {

        ArrayList<Object> result = new ArrayList<Object>();
        ArrayList<Object> selected = new ArrayList<>();
        permutation.permute(selected, Arrays.<Object>asList("1", "2", "3", "4"), result);

        assertThat(result.size(), is(24));

        dumpResult(result);
    }

    @Test
    public void testWith5ElementInput() throws Exception {

        ArrayList<Object> result = new ArrayList<Object>();
        ArrayList<Object> selected = new ArrayList<>();
        permutation.permute(selected, Arrays.<Object>asList("1", "2", "3", "4", "5"), result);

        assertThat(result.size(), is(120));

        dumpResult(result);
    }



    private void dumpResult(List<Object> result) {
        for (Object item : result) {
            System.out.print(item);
        }

        System.out.println("##");

    }
}
