package other.a1;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

/**
 * Created by U292148 on 2014.02.12..
 */
public class StrSortTest {

    private StrSort strSort;

    @Before
    public void setUp() throws Exception {
        strSort = new StrSort();

    }

    @Test
    public void testStrSortNull() throws Exception {
        final String[] actual = strSort.strSort(null);
        assertThat(actual, nullValue());
    }

    @Test
    public void testStrSortEmpty() throws Exception {
        final String[] emptyString = {};
        final String[] actual = strSort.strSort(emptyString);
        assertThat(actual, notNullValue());
        assertThat(actual, sameInstance(emptyString));
    }

    @Test
    public void testStrSortOne() throws Exception {
        final String[] actual = strSort.strSort(new String[] { "AAA" });
        assertThat(actual[0], equalTo("AAA"));
    }

    @Test
    public void testStrSort2() throws Exception {
        String[] actual = strSort.strSort(new String[] { "AAA", "WWW" });
        assertThat(actual[0], equalTo("AAA"));
        assertThat(actual[1], equalTo("WWW"));

        actual = strSort.strSort(new String[] { "QQQ", "AAA" });
        assertThat(actual[0], equalTo("AAA"));
        assertThat(actual[1], equalTo("QQQ"));
    }

    @Test
    public void testStrSort3() throws Exception {
        String[] actual = strSort.strSort(new String[] { "WWW", "", "AAA" });
        assertThat(actual[0], equalTo(""));
        assertThat(actual[1], equalTo("AAA"));
        assertThat(actual[2], equalTo("WWW"));
    }

}
