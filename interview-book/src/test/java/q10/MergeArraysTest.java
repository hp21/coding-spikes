package q10;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.font.CoreMetrics;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

/**
 * Created by U292148 on 2013.12.11..
 */
public class MergeArraysTest {

    private MergeArrays merger;

    @Before
    public void setUp() throws Exception {
        merger = new MergeArrays();
    }

    @Test
    public void testMergeNullA1() throws Exception {

        int[] a1 = null;
        int[] a2 = null;

        int[] actual = merger.merge(a1, 0, a2, 0);
        assertThat(actual, nullValue());

        a1 = new int[] {};
        a2 = null;
        actual = merger.merge(a1, 0, a2, 0);
        assertThat(actual, sameInstance(a1));

        a1 = new int[] {};
        a2 = new int[] {};
        actual = merger.merge(a1, 0, a2, 0);
        assertThat(actual, sameInstance(a1));

    }

    @Test
    public void testWithOneEmpty() throws Exception {

        int[] a1 = new int[100];
        a1[0] = 4;
        int[] a2 = new int[] {};

        int[] actual = merger.merge(a1, 1, a2, 0);
        assertThat(actual[0], equalTo(4));

        a1 = new int[100];
        a2 = new int[] { 2 };

        actual = merger.merge(a1, 0, a2, 1);
        assertThat(actual[0], equalTo(2));

    }

    @Test
    public void testWithTwoEmpty() throws Exception {

        int[] a1 = new int[100];
        a1[0] = 1;
        a1[1] = 4;
        int[] a2 = new int[] {};

        int[] actual = merger.merge(a1, 2, a2, 0);
        assertThat(actual[0], equalTo(1));
        assertThat(actual[1], equalTo(4));

        a1 = new int[100];
        a2 = new int[] { 2, 5 };

        actual = merger.merge(a1, 0, a2, 2);
        assertThat(actual[0], equalTo(2));
        assertThat(actual[1], equalTo(5));

    }

    @Test
    public void testWithOneOne() throws Exception {

        int[] a1 = new int[100];
        a1[0] = 4;
        int[] a2 = new int[] { 2 };

        int[] actual = merger.merge(a1, 1, a2, a2.length);
        assertThat(actual[0], equalTo(2));
        assertThat(actual[1], equalTo(4));

        a1 = new int[100];
        a1[0] = 3;
        a2 = new int[] { 12 };

        actual = merger.merge(a1, 1, a2, 1);
        assertThat(actual[0], equalTo(3));
        assertThat(actual[1], equalTo(12));

    }

    @Test
    public void testWithOneTwo() throws Exception {

        int[] a1 = new int[100];
        a1[0] = 4;
        int[] a2 = new int[] { 1, 2 };

        int[] actual = merger.merge(a1, 1, a2, a2.length);
        assertThat(actual[0], equalTo(1));
        assertThat(actual[1], equalTo(2));
        assertThat(actual[2], equalTo(4));

        a1 = new int[100];
        a1[0] = -1;
        a2 = new int[] { 1, 2 };

        actual = merger.merge(a1, 1, a2, a2.length);
        assertThat(actual[0], equalTo(-1));
        assertThat(actual[1], equalTo(1));
        assertThat(actual[2], equalTo(2));

    }

    @Test
    public void testWithTwoOne() throws Exception {

        int[] a1 = new int[100];
        a1[0] = 4;
        a1[1] = 7;
        int[] a2 = new int[] { 1 };

        int[] actual = merger.merge(a1, 2, a2, a2.length);
        assertThat(actual[0], equalTo(1));
        assertThat(actual[1], equalTo(4));
        assertThat(actual[2], equalTo(7));

        a1 = new int[100];
        a1[0] = -1;
        a1[1] = 6;
        a2 = new int[] { 2 };

        actual = merger.merge(a1, 2, a2, a2.length);
        assertThat(actual[0], equalTo(-1));
        assertThat(actual[1], equalTo(2));
        assertThat(actual[2], equalTo(6));

    }

}
