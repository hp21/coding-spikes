package strcalc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * User: hp21 Date: 2013.10.18. Time: 19:26
 * 
 * See: http://osherove.com/tdd-kata-1/
 */
public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @Before
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void testEmptyString() throws Exception {

        final int actual = stringCalculator.add("");
        assertThat(actual, equalTo(0));
    }

    @Test
    public void testOneArgument() throws Exception {

        final int actual = stringCalculator.add("6");
        assertThat(actual, equalTo(6));
    }

    @Test
    @Ignore
    public void testOneArgumenttrailingComma() throws Exception {

        final int actual = stringCalculator.add("6,"); // TODO: OK????
        assertThat(actual, equalTo(6));
    }

    @Test
    @Ignore
    public void testOneArgumentNegative() throws Exception {

        final int actual = stringCalculator.add("-6");
        assertThat(actual, equalTo(-6));
    }

    @Test
    public void testTwoArguments() throws Exception {

        final int actual = stringCalculator.add("6,8");
        assertThat(actual, equalTo(14));
    }

    @Test
    @Ignore
    public void testTwoArgumentsNegative() throws Exception {

        final int actual = stringCalculator.add("-6,-8");
        assertThat(actual, equalTo(-14));
    }

    @Test
    public void testThreeArguments() throws Exception {

        final int actual = stringCalculator.add("6,8,5");
        assertThat(actual, equalTo(19));
    }

    @Test(expected = Exception.class)
    public void testArgumentsWithTrailingDelims() throws Exception {

        final int actual = stringCalculator.add("6,");
    }

    @Test
    @Ignore
    public void test4Arguments() throws Exception {

        final int actual = stringCalculator.add("6,8\n2,3");
        assertThat(actual, equalTo(19));
    }

    @Test(expected = RuntimeException.class)
    @Ignore
    public void test4ArgumentsStrangDelims() throws Exception {

        final int actual = stringCalculator.add("6,8\n,2");
    }

    @Test(expected = RuntimeException.class)
    @Ignore
    public void test4ArgumentsStrangDelims2() throws Exception {

        final int actual = stringCalculator.add("6\n,");
    }

}
