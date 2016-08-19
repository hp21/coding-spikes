package substr;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class LongestCommonSubstringTest {

    private ILongestCommonSubstring finder;

    @Before
    public void setUp() {
       finder = new LongestCommonSubstring();
    }

    @Test
    public void testLongestSubstring() throws Exception {
        String actual = finder.longestCommonSubstring("asd", "q");
        assertThat(actual, equalTo(""));
        //
        actual = finder.longestCommonSubstring("asd", "a");
        assertThat(actual, equalTo("a"));
        //
        actual = finder.longestCommonSubstring("asd", "as");
        assertThat(actual, equalTo("as"));

        actual = finder.longestCommonSubstring("asd", "asd");
        assertThat(actual, equalTo("asd"));

        actual = finder.longestCommonSubstring("asd", "asda");
        assertThat(actual, equalTo("asd"));

        actual = finder.longestCommonSubstring("asd", "cer");
        assertThat(actual, equalTo(""));

        actual = finder.longestCommonSubstring("asdaqweasdqweraa", "qwe");
        assertThat(actual, equalTo("qwe"));

        actual = finder.longestCommonSubstring("asdaqweasdqweraa", "qwezz");
        assertThat(actual, equalTo("qwe"));

        actual = finder.longestCommonSubstring("asdaqweasdqweraa", "bbqwezz");
        assertThat(actual, equalTo("qwe"));
    }




}