package eval;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Date: 2013.06.05. Time: 16:44 To change this template use File | Settings |
 * File Templates.
 */
public class SumOfDigitsTest {

    private SumOfDigits sumOfDigits;

    @Before
    public void setUp() {
        sumOfDigits = new SumOfDigits();
    }

    @Test
    public void zeroTest() {
        final int actual = sumOfDigits.sumOfSum(0);
        Assert.assertThat(actual, CoreMatchers.equalTo(0));
    }

    @Test
     public void oneTest() {
        final int actual = sumOfDigits.sumOfSum(1);
        Assert.assertThat(actual, CoreMatchers.equalTo(1));
    }

    @Test
    public void tenTest() {
        int actual = sumOfDigits.sumOfSum(10);
        Assert.assertThat(actual, CoreMatchers.equalTo(1));

        actual = sumOfDigits.sumOfSum(11);
        Assert.assertThat(actual, CoreMatchers.equalTo(2));

        actual = sumOfDigits.sumOfSum(17);
        Assert.assertThat(actual, CoreMatchers.equalTo(8));

        actual = sumOfDigits.sumOfSum(97);
        Assert.assertThat(actual, CoreMatchers.equalTo(16));
    }

    @Test
    public void hundredTest() {
        int actual = sumOfDigits.sumOfSum(100);
        Assert.assertThat(actual, CoreMatchers.equalTo(1));

        actual = sumOfDigits.sumOfSum(110);
        Assert.assertThat(actual, CoreMatchers.equalTo(2));

        actual = sumOfDigits.sumOfSum(170);
        Assert.assertThat(actual, CoreMatchers.equalTo(8));

        actual = sumOfDigits.sumOfSum(970);
        Assert.assertThat(actual, CoreMatchers.equalTo(16));

        actual = sumOfDigits.sumOfSum(547);
        Assert.assertThat(actual, CoreMatchers.equalTo(16));

        actual = sumOfDigits.sumOfSum(999);
        Assert.assertThat(actual, CoreMatchers.equalTo(27));

        actual = sumOfDigits.sumOfSum(102);
        Assert.assertThat(actual, CoreMatchers.equalTo(3));
    }

    @Test
    public void miscTest() {
        int actual = sumOfDigits.sumOfSum(1010406);
        Assert.assertThat(actual, CoreMatchers.equalTo(12));}
}


