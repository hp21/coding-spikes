package recursion;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * User: hp21 Date: 2013.05.23. Time: 12:44
 */
public class SumTest {

    @Test
    public void add0() {
        final Sum sum = new Sum();
        final int actual = sum.sum(0);
        Assert.assertThat(actual, CoreMatchers.equalTo(0));
    }

    @Test
    public void add1() {
        final Sum sum = new Sum();
        final int actual = sum.sum(1);
        Assert.assertThat(actual, CoreMatchers.equalTo(1));
    }

    @Test
    public void add2() {
        final Sum sum = new Sum();
        final int actual = sum.sum(2);
        Assert.assertThat(actual, CoreMatchers.equalTo(3));
    }

    @Test
    public void add10() {
        final Sum sum = new Sum();
        final int actual = sum.sum(10);
        Assert.assertThat(actual, CoreMatchers.equalTo(55));
    }

    @Test
    public void add_1() {
        final Sum sum = new Sum();
        final int actual = sum.sum(-1);
        Assert.assertThat(actual, CoreMatchers.equalTo(-1));
    }

    @Test
    public void add_2() {
        final Sum sum = new Sum();
        final int actual = sum.sum(-2);
        Assert.assertThat(actual, CoreMatchers.equalTo(-3));
    }

    @Test
    public void add_10() {
        final Sum sum = new Sum();
        final int actual = sum.sum(-10);
        Assert.assertThat(actual, CoreMatchers.equalTo(-55));
    }
}
