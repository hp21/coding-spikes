package eval;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

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
        assertThat(actual, equalTo(0));
    }

    @Test
    public void oneTest() {
        final int actual = sumOfDigits.sumOfSum(1);
        assertThat(actual, equalTo(1));
    }

    @Test
    public void tenTest() {
        int actual = sumOfDigits.sumOfSum(10);
        assertThat(actual, equalTo(1));

        actual = sumOfDigits.sumOfSum(11);
        assertThat(actual, equalTo(2));

        actual = sumOfDigits.sumOfSum(17);
        assertThat(actual, equalTo(8));

        actual = sumOfDigits.sumOfSum(97);
        assertThat(actual, equalTo(16));
    }

    @Test
    public void hundredTest() {
        int actual = sumOfDigits.sumOfSum(100);
        assertThat(actual, equalTo(1));

        actual = sumOfDigits.sumOfSum(110);
        assertThat(actual, equalTo(2));

        actual = sumOfDigits.sumOfSum(170);
        assertThat(actual, equalTo(8));

        actual = sumOfDigits.sumOfSum(970);
        assertThat(actual, equalTo(16));

        actual = sumOfDigits.sumOfSum(547);
        assertThat(actual, equalTo(16));

        actual = sumOfDigits.sumOfSum(999);
        assertThat(actual, equalTo(27));

        actual = sumOfDigits.sumOfSum(102);
        assertThat(actual, equalTo(3));
    }

    @Test
    public void miscTest() {
        int actual = sumOfDigits.sumOfSum(1010406);
        assertThat(actual, equalTo(12));
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeTest() {
        int actual = sumOfDigits.sumOfSum(-1010406);
        assertThat(actual, equalTo(12));
    }

}
