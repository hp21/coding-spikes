package rmdupl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * User: hp21 Date: 2013.11.13. Time: 13:47
 */
public class RemoveDuplicatesTest {

    private IRemoveDuplicates removeDuplicates;

    @Before
    public void setUp() {
        removeDuplicates = new RemoveDuplicates();
    }

    @Test
    public void nullTest() throws Exception {
        final String actual = removeDuplicates.removeDuplicates(null);
        assertThat(actual, nullValue());

    }

    @Test
    public void emptyCharTest() throws Exception {
        final String actual = removeDuplicates.removeDuplicates("");
        assertThat(actual.length(), equalTo(0));
    }

    @Test
    public void oneCharTest() throws Exception {
        final String actual = removeDuplicates.removeDuplicates("q");
        assertThat(actual, equalTo("q"));
    }

    @Test
    public void twoCharTest() throws Exception {
        final String actual = removeDuplicates.removeDuplicates("qq");
        assertThat(actual, equalTo("q"));
    }

    @Test
    public void threeCharTest() throws Exception {
        final String actual = removeDuplicates.removeDuplicates("qqq");
        assertThat(actual, equalTo("q"));
    }

    @Test
    public void twoChunksOneChar() throws Exception {
        final String actual = removeDuplicates.removeDuplicates("A A");
        assertThat(actual, equalTo("A A"));
    }

    @Test
    public void threeChunksOneChar() throws Exception {
        String actual = removeDuplicates.removeDuplicates("A A A");
        assertThat(actual, equalTo("A A A"));

        actual = removeDuplicates.removeDuplicates("A B C");
        assertThat(actual, equalTo("A B C"));

        actual = removeDuplicates.removeDuplicates("A B C ");
        assertThat(actual, equalTo("A B C "));
    }

    @Test
    public void twoChunksmroeChar() throws Exception {
        String actual = removeDuplicates.removeDuplicates("AA A");
        assertThat(actual, equalTo("A A"));

        actual = removeDuplicates.removeDuplicates("AAAAAA A");
        assertThat(actual, equalTo("A A"));

        actual = removeDuplicates.removeDuplicates("AAAAAA AAA");
        assertThat(actual, equalTo("A A"));

        actual = removeDuplicates.removeDuplicates("AAAAAA CCC");
        assertThat(actual, equalTo("A C"));

        actual = removeDuplicates.removeDuplicates("AAAAAA    CCC");
        assertThat(actual, equalTo("A C"));
    }

    @Test
    public void moreChunksmroeChar() throws Exception {
        String actual = removeDuplicates.removeDuplicates("AA AA    A");
        assertThat(actual, equalTo("A A A"));

        actual = removeDuplicates.removeDuplicates("AAAA AA A");
        assertThat(actual, equalTo("A A A"));

        actual = removeDuplicates.removeDuplicates("AA B AAA");
        assertThat(actual, equalTo("A B A"));

        actual = removeDuplicates.removeDuplicates("AAAAAA CCC");
        assertThat(actual, equalTo("A C"));

        actual = removeDuplicates.removeDuplicates("AAAAAA    CCC");
        assertThat(actual, equalTo("A C"));

    }

    @Test
    public void otherTests() {
        String actual = removeDuplicates.removeDuplicates("ABCD   A");
        assertThat(actual, equalTo("ABCD A"));

    }

}
