package substr;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class LongestSubstringTest {

    private ILongestSubstring finder;

    @Before
    public void setUp() {
       finder = new LongestSubstring();
//        finder = new CommonSubstring2();
    }

    @Test
    public void testLongestSubstring() throws Exception {
        String actual = finder.longestSubstring("asd", "q");
        assertThat(actual, equalTo(""));
        //
        actual = finder.longestSubstring("asd", "a");
        assertThat(actual, equalTo("a"));
        //
        actual = finder.longestSubstring("asd", "as");
        assertThat(actual, equalTo("as"));

        actual = finder.longestSubstring("asd", "asd");
        assertThat(actual, equalTo("asd"));

        actual = finder.longestSubstring("asd", "asda");
        assertThat(actual, equalTo("asd"));

        actual = finder.longestSubstring("asd", "cer");
        assertThat(actual, equalTo(""));

        actual = finder.longestSubstring("asdaqweasdqweraa", "qwe");
        assertThat(actual, equalTo("qwe"));

        actual = finder.longestSubstring("asdaqweasdqweraa", "qwezz");
        assertThat(actual, equalTo("qwe"));

        actual = finder.longestSubstring("asdaqweasdqweraa", "bbqwezz");
        assertThat(actual, equalTo("qwe"));
    }
}