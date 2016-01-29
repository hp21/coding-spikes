package codility.binarygap;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by HP21 on 2016.01.29..
 */
public class SolutionTest {

    private Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @Test
    public void testSolution() throws Exception {
        int actual = this.solution.solution(0);

        assertThat(actual, is(0));
    }

    @Test
    public void testNegative() throws Exception {
        int actual = this.solution.solution(-2);
        assertThat(actual, is(0));
    }

    @Test
    public void testZero() throws Exception {
        int actual = this.solution.solution(0);
        assertThat(actual, is(0));
    }

    @Test
    public void testOne() throws Exception {
        int actual = this.solution.solution(1);
        assertThat(actual, is(0));
    }

    @Test
    public void testTwo() throws Exception {
        int actual = this.solution.solution(2);
        assertThat(actual, is(0));
    }

    @Test
    public void testThree() throws Exception {
        int actual = this.solution.solution(3);
        assertThat(actual, is(0));
    }


    @Test
    public void testFour() throws Exception {
        int actual = this.solution.solution(4);
        assertThat(actual, is(0));
    }

    @Test
    public void testNine() throws Exception {
        int actual = this.solution.solution(9);
        assertThat(actual, is(2));
    }

    @Test
    public void test44() throws Exception {
        int actual = this.solution.solution(44);
        assertThat(actual, is(1));
    }

    @Test
    public void test325() throws Exception {
        int actual = this.solution.solution(325);
        assertThat(actual, is(3));
    }



    @Test
    public void testN() {

        System.out.println("Zero " +  Integer.toBinaryString(0));
        System.out.println("1 " +  Integer.toBinaryString(1));
        System.out.println("2 " +  Integer.toBinaryString(2));
        System.out.println("3 " +  Integer.toBinaryString(3));
        System.out.println("4 " +  Integer.toBinaryString(4));
        System.out.println("5 " +  Integer.toBinaryString(5));
        System.out.println("6 " +  Integer.toBinaryString(6));
        System.out.println("9 " +  Integer.toBinaryString(9));

        System.out.println("325 " +  Integer.toBinaryString(325));

        System.out.println("5000 " +  Integer.toBinaryString(4097));

        String s = Integer.toBinaryString(12301234);

        System.out.println(s);

        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE - 12));

    }
}
