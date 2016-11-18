package bubble;

import api.ISort;
import inversions.InversionsDownwards;
import mergesort.MergeSort;

import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by hp21 on 2016.07.18..
 */
public class SortTest {

    public static final int INTS = 10000000;
    private ISort sorter;
    private InversionsDownwards inversions;

    @Before
    public void setUp() throws Exception {
        sorter = new BubbleSort();
//        sorter = new MergeSort();
        inversions = new InversionsDownwards();

    }

    @Test
    public void sortNullOrEmpty() throws Exception {

        int[] tested = null;
//        int invcount = inversions.inversions(tested);

        int[] actual = sorter.sort(tested);

        Assert.assertThat(sorter.sort(tested), sameInstance(tested));

        tested = new int[]{};
        Assert.assertThat(sorter.sort(tested), sameInstance(tested));
//        System.out.printf("Inversions: count=%d,computed=%d\n", invcount, sorter.getInversions());
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
//        int invcount = inversions.inversions(array);
        final int[] sorted = sorter.sort(array);

        assertThat(sorted[0], equalTo(5));
        assertThat(sorted[1], equalTo(6));
//        System.out.printf("20 Inversions: count=%d, computed%d\n", invcount, sorter.getInversions());
    }


    @Test
    public void testWithSize2AndSort() {

        int[] array = new int[]{6, 5};


//        int invcount = inversions.inversions(array);
        System.out.printf("30 Inversion vector: ", Arrays.toString(inversions.vector()));

        final int[] sorted = sorter.sort(array);

        assertThat(sorted[0], equalTo(5));
        assertThat(sorted[1], equalTo(6));

//        System.out.printf("30 Inversions: count=%d, computed=%d\n", invcount, sorter.getInversions());
    }

    @Test
    public void testWithSizeNSort() {

        int[] array = new int[]{6, 5, 10, 2, 3, 4, 1, 22};
//        int invcount = inversions.inversions(array);
        System.out.printf("40 Inversion vector: %s\n", Arrays.toString(inversions.vector()));

        final int[] sorted = sorter.sort(array);

        assertThat(sorted[0], equalTo(1));
        assertThat(sorted[1], equalTo(2));
        assertThat(sorted[2], equalTo(3));
        assertThat(sorted[3], equalTo(4));
        assertThat(sorted[4], equalTo(5));
        assertThat(sorted[5], equalTo(6));
        assertThat(sorted[6], equalTo(10));
        assertThat(sorted[7], equalTo(22));

//        System.out.printf("40 Inversions:count=%d, computed=%d\n", invcount, sorter.getInversions());
    }

    @Test
    public void testWithSizeNAndNoSort() {

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 10, 22};
//        int invcount = inversions.inversions(array);
        final int[] sorted = sorter.sort(array);

        assertThat(sorted[0], equalTo(1));
        assertThat(sorted[1], equalTo(2));
        assertThat(sorted[2], equalTo(3));
        assertThat(sorted[3], equalTo(4));
        assertThat(sorted[4], equalTo(5));
        assertThat(sorted[5], equalTo(6));
        assertThat(sorted[6], equalTo(10));
        assertThat(sorted[7], equalTo(22));

//        System.out.printf("50 Inversions:count=%d, computed=%d\n", invcount, sorter.getInversions());
    }

    @Test
    @Ignore
    public void testWithSize1000000AndRandomSort() {

        Random r = new Random();

        int[] array = new int[INTS];

        for (int i = 0; i < INTS; i++) {
            array[i] = r.nextInt(INTS - 1);
        }

        long start = System.currentTimeMillis();
        final int[] sorted = sorter.sort(array);
        long end = System.currentTimeMillis();


        for (int i = 0; i < sorted.length - 1; i++) {
            assertThat(sorted[i] <= sorted[i + 1], is(true));
        }


        System.out.println(((double) (end - start)) / 1000.0);


    }

}