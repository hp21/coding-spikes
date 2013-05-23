package recursion;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA. User: u292148 Date: 2013.05.23. Time: 15:48 To
 * change this template use File | Settings | File Templates.
 */
public class FindMinTest {

    @Test
    public void test1() {
        final FindMin findMin = new FindMin();
        final int actual = findMin.findmin(new int[] { 2 }, 1);
        assertThat(actual, equalTo(2));

    }

    @Test
    public void test2() {
        final FindMin findMin = new FindMin();
        final int actual = findMin.findmin(new int[] { 2, 5 }, 2);
        assertThat(actual, equalTo(2));

    }

    @Test
    public void test4() {
        final FindMin findMin = new FindMin();
        final int actual = findMin.findmin(new int[] { 2, -5, -10, 7 }, 4);
        assertThat(actual, equalTo(-10));

    }
}
