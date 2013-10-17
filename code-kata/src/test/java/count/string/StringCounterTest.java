package count.string;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA. User: U292148 Date: 2013.10.16. Time: 21:10 To
 * change this template use File | Settings | File Templates.
 */
public class StringCounterTest {

    private StringCounter stringCounter;

    @Before
    public void setUp() {
        stringCounter = new StringCounter();
    }

    @Test
    public void test__1() {
        final String actual = stringCounter.count(null);
        Assert.assertThat(actual, equalTo(""));
    }

    @Test
    public void test_0() {
        final String actual = stringCounter.count("");
        Assert.assertThat(actual, equalTo(""));
    }

    @Test
    public void test_1() {
        final String actual = stringCounter.count("a");
        Assert.assertThat(actual, equalTo("a1"));
    }

    @Test
    public void test_2() {
        final String actual = stringCounter.count("aaaa");
        Assert.assertThat(actual, equalTo("a4"));
    }

    @Test
    public void test_3() {
        final String actual = stringCounter.count("aaaab");
        Assert.assertThat(actual, equalTo("a4b1"));
    }

    @Test
    public void test_4() {
        final String actual = stringCounter.count("aaaabbb");
        Assert.assertThat(actual, equalTo("a4b3"));
    }

    @Test
    public void test_5() {
        final String actual = stringCounter.count("aaaabbbaccccca");
        Assert.assertThat(actual, equalTo("a4b3a1c5a1"));
    }
}
