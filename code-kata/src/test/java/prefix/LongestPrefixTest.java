package prefix;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by U292148 on 2016.08.18..
 */
public class LongestPrefixTest {
    private LongestPrefixLength prefixer;
    private LongestPrefixString prefixerString;

    @Before
    public void setUp() throws Exception {
        prefixer = new LongestPrefixLength();
        prefixerString = new LongestPrefixString();
    }

    @Test
    public void longestPrefixwithEmpties() throws Exception {

        int actual = prefixer.longestPrefixLength(null, null);
        assertThat(actual, is(0));

        actual = prefixer.longestPrefixLength(null, "asd");
        assertThat(actual, is(0));

        actual = prefixer.longestPrefixLength("qqq", "");
        assertThat(actual, is(0));

        actual = prefixer.longestPrefixLength("", "a");
        assertThat(actual, is(0));

    }

    @Test
    public void longestPrefixwith1Char() throws Exception {

        int actual = prefixer.longestPrefixLength("asdf", "q");
        assertThat(actual, is(0));

        actual = prefixer.longestPrefixLength("asdf", "a");
        assertThat(actual, is(1));
    }

    @Test
    public void longestPrefixwith1CharStrings() throws Exception {

        String actual = prefixerString.longestPrefix("asdf", "q");
        assertThat(actual, is(""));

        actual = prefixerString.longestPrefix("asdf", "a");
        assertThat(actual, is("a"));
    }

    @Test
    public void longestPrefixwithMoreChars() throws Exception {

        int actual = prefixer.longestPrefixLength("asdf", "as");
        assertThat(actual, is(2));

        actual = prefixer.longestPrefixLength("asdf", "asdf");
        assertThat(actual, is(4));

        actual = prefixer.longestPrefixLength("asdf", "asqqq");
        assertThat(actual, is(2));
    }

    @Test
    public void longestPrefixwithMoreCharsStrings() throws Exception {

        String actual = prefixerString.longestPrefix("asdf", "as");
        assertThat(actual, is("as"));

        actual = prefixerString.longestPrefix("asdf", "asdf");
        assertThat(actual, is("asdf"));

        actual = prefixerString.longestPrefix("asdf", "asqqq");
        assertThat(actual, is("as"));
    }

}