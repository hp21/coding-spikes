package recursion;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA. User: u292148 Date: 2013.05.31. Time: 12:55 To
 * change this template use File | Settings | File Templates.
 */
public class PalindromeTest {

    private PalindRome service;

    @Before
    public void setUp() {
        service = new PalindRome();
    }

    @Test
    public void testEmpty() {
        final boolean actual = service.isPalindrome("");
        assertThat(actual, equalTo(true));
    }

    @Test
    public void testOne() {
        final boolean actual = service.isPalindrome("A");
        assertThat(actual, equalTo(true));
    }

    @Test
    public void test2Good() {
        final boolean actual = service.isPalindrome("QQ");
        assertThat(actual, equalTo(true));
    }

    @Test
    public void test2Bad() {
        final boolean actual = service.isPalindrome("QA");
        assertThat(actual, equalTo(false));
    }

    @Test
    public void test3Good() {
        final boolean actual = service.isPalindrome("ZZZ");
        assertThat(actual, equalTo(true));
    }

    @Test
    public void test3Bad() {
        final boolean actual = service.isPalindrome("AQQ");
        assertThat(actual, equalTo(false));
    }

}
