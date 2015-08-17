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

        List<List<String>> actual = permutation.permute(Arrays.<String>asList("1"));

        assertThat(actual.size(), is(1));

        dumpResult(actual);
    }

    @Test
    public void testWithTwoElementInput() throws Exception {

        List<List<String>> actual = permutation.permute(Arrays.<String>asList("1", "2"));

        assertThat(actual.size(), is(2));

        dumpResult(actual);
    }

    @Test
    public void testWith3ElementInput() throws Exception {

        List<List<String>> actual = permutation.permute(Arrays.<String>asList("1", "2", "3"));

        assertThat(actual.size(), is(6));

        dumpResult(actual);
    }

    @Test
    public void testWith4ElementInput() throws Exception {

        List<List<String>> actual = permutation.permute(Arrays.<String>asList("1", "2", "3", "4"));

        assertThat(actual.size(), is(24));

        dumpResult(actual);
    }

    @Test
    public void testWith5ElementInput() throws Exception {

        List<List<String>> actual = permutation.permute(Arrays.<String>asList("1", "2", "3", "4", "5"));

        assertThat(actual.size(), is(120));

        dumpResult(actual);
    }

    @Test
    public void test2WithSelectedElement() throws Exception {

        List<String> selected = new ArrayList<>(Arrays.asList("1"));

        List<List<String>> actual = permutation.permute(selected, Arrays.<String>asList("1"));

        assertThat(actual.size(), is(1));

        dumpResult(actual);
    }

    @Test
    public void test2With1SelectedElement() throws Exception {

        List<String> selected = new ArrayList<>(Arrays.asList("1"));

        List<List<String>> actual = permutation.permute(selected, Arrays.<String>asList("1", "2"));

        dumpResult(actual);
        assertThat(actual.size(), is(1));

    }

    @Test
    public void test4With1SelectedElement() throws Exception {

        List<String> selected = new ArrayList<>(Arrays.asList("0"));

        List<List<String>> actual = permutation.permute(selected, Arrays.<String>asList("0", "1", "2", "3"));

        dumpResult(actual);
        assertThat(actual.size(), is(6));

    }

    @Test
    public void test5With1SelectedElement() throws Exception {

        List<String> selected = new ArrayList<>(Arrays.asList("0"));

        List<List<String>> actual = permutation.permute(selected, Arrays.<String>asList("0", "1", "2", "3", "4"));

        dumpResult(actual);
        assertThat(actual.size(), is(24));

    }

    private void dumpResult(List<List<String>> result) {
        for (Object item : result) {
            System.out.print(item);
        }

        System.out.println("##");

    }
}

