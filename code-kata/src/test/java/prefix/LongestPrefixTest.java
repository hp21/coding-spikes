package prefix;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by U292148 on 2016.08.18..
 */
public class LongestPrefixTest {
    private LongestPrefix prefixer;

    @Before
    public void setUp() throws Exception {
        prefixer = new LongestPrefix();
    }

    @Test
    public void longestPrefixwithEmpties() throws Exception {

        int actual = prefixer.longestPrefix(null, null);
        assertThat(actual, is(0));

        actual = prefixer.longestPrefix(null, "asd");
        assertThat(actual, is(0));

        actual = prefixer.longestPrefix("qqq", "");
        assertThat(actual, is(0));

        actual = prefixer.longestPrefix("", "a");
        assertThat(actual, is(0));

    }

    @Test
    public void longestPrefixwith1Char() throws Exception {

        int actual = prefixer.longestPrefix("asdf", "q");
        assertThat(actual, is(0));

        actual = prefixer.longestPrefix("asdf", "a");
        assertThat(actual, is(1));

        actual = prefixer.longestPrefix("asdf", "a");
    }

    @Test
    public void longestPrefixwithMoreChars() throws Exception {

        int actual = prefixer.longestPrefix("asdf", "as");
        assertThat(actual, is(2));

        actual = prefixer.longestPrefix("asdf", "asdf");
        assertThat(actual, is(4));

        actual = prefixer.longestPrefix("asdf", "asqqq");
        assertThat(actual, is(2));
    }

}