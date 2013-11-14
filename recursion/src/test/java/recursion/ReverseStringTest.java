package recursion;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * User: hp21 Date: 2013.11.14. Time: 15:06
 */
public class ReverseStringTest {

    private ReverseString reverseString;

    @Before
    public void setUp() {
        reverseString = new ReverseString();
    }

    @Test
    public void testReverseNull() throws Exception {
        final String actual = reverseString.reverse(null);
        assertThat(actual, nullValue());
    }

    @Test
    public void testReverseEmpty() throws Exception {
        final String actual = reverseString.reverse("");
        assertThat(actual, equalTo(""));
    }

    @Test
    public void testReverseOneChar() throws Exception {
        final String actual = reverseString.reverse("Q");
        assertThat(actual, equalTo("Q"));
    }

    @Test
    public void testReverseTwoChar() throws Exception {
        final String actual = reverseString.reverse("AB");
        assertThat(actual, equalTo("BA"));
    }

    @Test
    public void testReverseThreeChar() throws Exception {
        final String actual = reverseString.reverse("ABC");
        assertThat(actual, equalTo("CBA"));
    }

    @Test
    public void testReverseFourChar() throws Exception {
        String actual = reverseString.reverse("ABCD");
        assertThat(actual, equalTo("DCBA"));

        actual = reverseString.reverse("AABCD");
        assertThat(actual, equalTo("DCBAA"));

    }

}
