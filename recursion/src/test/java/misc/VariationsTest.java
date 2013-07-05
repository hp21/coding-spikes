package misc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Date: 2013.06.11. Time: 12:11
 */
public class VariationsTest {

    private Variations variations;

    @Before
    public void setUp() throws Exception {
        variations = new Variations(1);
    }

    @Test
    @Ignore
    public void testAllVariations1() throws Exception {

        final List<List<Integer>> actual = variations.allVariations();
        assertThat(actual, notNullValue());

        assertThat(actual.size(), equalTo(9));

        for (int i = 0; i < 9; i++) {
            final List<Integer> list = actual.get(i);
            assertThat(list.get(0), equalTo(i));
        }

    }
}
