package substr;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CommonSubstringTest {

    private ILongestSubstring2 finder;

    @Before
    public void setUp() {
        finder = new CommonSubstring2();
    }

    @Test
    public void testLongestSubstring() throws Exception {
        String actual = finder.longestSubstring("asd");
        assertThat(actual, equalTo(""));
        //
        actual = finder.longestSubstring("asda");
        assertThat(actual, equalTo("a"));

        actual = finder.longestSubstring("asdas");
        assertThat(actual, equalTo("as"));

        actual = finder.longestSubstring("asdasd");
        assertThat(actual, equalTo("asd"));

        actual = finder.longestSubstring("asdXasd");
        assertThat(actual, equalTo("asd"));

        actual = finder.longestSubstring("asdaqweasdqwearaa");
        assertThat(actual, equalTo("qwea"));

    }


}