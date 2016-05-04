package codility.cyclicrotation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;

/**
 * Created by U292148 on 2016.02.02..
 */
public class SolutionTest {

    private Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @Test
    public void testSolutionMultpily() throws Exception {

        int[] expected = new int[]{0, 1, 2, 3};
        int[] actual = this.solution.solution(expected, 12);

        Assert.assertThat(actual, sameInstance(expected));

        actual = this.solution.solution(expected, 4);
        Assert.assertThat(actual, sameInstance(expected));


        actual = this.solution.solution(expected, 24);
        Assert.assertThat(actual, sameInstance(expected));
    }

    @Test
    public void testGcd() {

        int actual = solution.gcd(6, 1);
        Assert.assertThat(actual, is(1));


        actual = solution.gcd(6, 2);
        Assert.assertThat(actual, is(2));

        actual = solution.gcd(6, 3);
        Assert.assertThat(actual, is(3));


        actual = solution.gcd(6, 4);
        Assert.assertThat(actual, is(2));

        actual = solution.gcd(6, 5);
        Assert.assertThat(actual, is(1));


        actual = solution.gcd(6, 6);
        Assert.assertThat(actual, is(6));
    }

    @Test
    public void test5shift1() {

        int[] arr = new int[]{0, 1, 2};
        System.out.println(Arrays.toString(arr));

        int[] exptected3_1 = new int[]{2, 0, 1};


        int[] actual = solution.solution(arr, 1);
        System.out.println(Arrays.toString(actual));

        for (int i = 0; i < actual.length; i++) {
            Assert.assertThat(actual[i], is(exptected3_1[i]));
        }

        arr = new int[]{0, 1, 2};
        int[] exptected3_2 = new int[]{1, 2, 0};


        actual = solution.solution(arr, 2);
        System.out.println(Arrays.toString(actual));

        for (int i = 0; i < actual.length; i++) {
            Assert.assertThat(actual[i], is(exptected3_2[i]));
        }

        //=================
        arr = new int[]{0, 1, 2};
        int[] exptected3_3 = new int[]{0, 1, 2};


        actual = solution.solution(arr, 3);
        System.out.println(Arrays.toString(actual));

        for (int i = 0; i < actual.length; i++) {
            Assert.assertThat(actual[i], is(exptected3_3[i]));
        }

    }

    @Test
    public void test3shift4() {
        //=================
        int[] arr = new int[]{0, 1, 2};
        int[] exptected3_4 = new int[]{2, 0, 1};


        int[] actual = solution.solution(arr, 4);
        System.out.println(Arrays.toString(actual));

        for (int i = 0; i < actual.length; i++) {
            Assert.assertThat(actual[i], is(exptected3_4[i]));
        }

    }


    @Test
    public void test3shift5() {


        int[] arr = new int[]{0, 1, 2};
        int[] exptected3_5 = new int[]{1, 2, 0};


        int[] actual = solution.solution(arr, 5);
        System.out.println(Arrays.toString(actual));

        for (int i = 0; i < actual.length; i++) {
            Assert.assertThat(actual[i], is(exptected3_5[i]));
        }

    }


    @Test
    public void test5shift3() {

        int[] arr = new int[]{3, 8, 9, 7, 6};
        int[] exptected5_3 = new int[]{9, 7, 6, 3, 8};


        int[] actual = solution.solution(arr, 3);
        System.out.println(Arrays.toString(actual));

        for (int i = 0; i < actual.length; i++) {
            Assert.assertThat(actual[i], is(exptected5_3[i]));
        }

    }

    @Test
    public void testEmpty() {
        int[] actual = solution.solution(new int[]{}, 0);
        Assert.assertThat(actual.length, is(0));
    }

}