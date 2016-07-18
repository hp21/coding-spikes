package sort;

import api.ISort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

/**
 * Created by u292148 on 2016.07.18..
 */
public class SortTest {

    private ISort sorter;

    @Before
    public void setUp() throws Exception {
        sorter = new BubbleSort();

    }

    @Test
    public void sortNullOrEmpty() throws Exception {

        int[] tested = null;

        int[] actual = sorter.sort(tested);

        Assert.assertThat(sorter.sort(tested), sameInstance(tested));

        tested = new int[]{};
        Assert.assertThat(sorter.sort(tested), sameInstance(tested));
        System.out.printf("Inversions: %d\n", sorter.getInversions());
    }

    @Test
    public void test0() {

        int[] array = new int[]{};
        final int[] sorted = sorter.sort(array);

        assertThat(sorted.length, equalTo(0));
        assertThat(sorted, sameInstance(array));

        System.out.printf("0 Inversions: %d\n", sorter.getInversions());
    }

    @Test
    public void testWithSize1() {

        int[] array = new int[]{5};
        final int[] sorted = sorter.sort(array);

        assertThat(sorted[0], equalTo(5));
        System.out.printf("10 Inversions: %d\n", sorter.getInversions());
    }

    @Test
    public void testWithSize2NoSort() {

        int[] array = new int[]{5, 6};
        final int[] sorted = sorter.sort(array);

        assertThat(sorted[0], equalTo(5));
        assertThat(sorted[1], equalTo(6));
        System.out.printf("20 Inversions: %d\n", sorter.getInversions());
    }


    @Test
    public void testWithSize2AndSort() {

        int[] array = new int[]{6, 5};
        final int[] sorted = sorter.sort(array);

        assertThat(sorted[0], equalTo(5));
        assertThat(sorted[1], equalTo(6));

        System.out.printf("30 Inversions: %d\n", sorter.getInversions());
    }

    @Test
    public void testWithSizeNSort() {

        int[] array = new int[]{6, 5, 10, 2, 3, 4, 1, 22};
        final int[] sorted = sorter.sort(array);

        assertThat(sorted[0], equalTo(1));
        assertThat(sorted[1], equalTo(2));
        assertThat(sorted[2], equalTo(3));
        assertThat(sorted[3], equalTo(4));
        assertThat(sorted[4], equalTo(5));
        assertThat(sorted[5], equalTo(6));
        assertThat(sorted[6], equalTo(10));
        assertThat(sorted[7], equalTo(22));

        System.out.printf("40 Inversions: %d\n", sorter.getInversions());
    }

    public void testWithSizeNAndNoSort() {

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 10, 22};
        final int[] sorted = sorter.sort(array);

        assertThat(sorted[0], equalTo(1));
        assertThat(sorted[1], equalTo(2));
        assertThat(sorted[2], equalTo(3));
        assertThat(sorted[3], equalTo(4));
        assertThat(sorted[4], equalTo(5));
        assertThat(sorted[5], equalTo(6));
        assertThat(sorted[6], equalTo(10));
        assertThat(sorted[7], equalTo(22));

        System.out.printf("50 Inversions: %d\n", sorter.getInversions());
    }

}