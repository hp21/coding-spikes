package buzz;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import fizzbuzz.FizzBuzz;

/**
 * Created with IntelliJ IDEA. User: hp21 Date: 2013.05.16. Time: 13:44 To
 * change this template use File | Settings | File Templates.
 */
public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void test_1() {
        final String actual = fizzBuzz.fizzBuzz(1);
        Assert.assertThat(actual, equalTo("1"));
    }

    @Test
    public void test_2() {
        final String actual = fizzBuzz.fizzBuzz(2);
        Assert.assertThat(actual, equalTo("2"));
    }

    @Test
    public void test_3() {
        final String actual = fizzBuzz.fizzBuzz(3);
        Assert.assertThat(actual, equalTo("fizz"));
    }

    @Test
    public void test_4() {
        final String actual = fizzBuzz.fizzBuzz(4);
        Assert.assertThat(actual, equalTo("4"));
    }

    @Test
    public void test_5() {
        final String actual = fizzBuzz.fizzBuzz(5);
        Assert.assertThat(actual, equalTo("buzz"));
    }


    @Test
    public void test_6() {
        final String actual = fizzBuzz.fizzBuzz(6);
        Assert.assertThat(actual, equalTo("fizz"));
    }

    @Test
    public void test_10() {
        final String actual = fizzBuzz.fizzBuzz(10);
        Assert.assertThat(actual, equalTo("buzz"));
    }

    @Ignore
    @Test
    public void test_15() {
        final String actual = fizzBuzz.fizzBuzz(15);
        Assert.assertThat(actual, equalTo("fizzbuzz"));
    }
}
