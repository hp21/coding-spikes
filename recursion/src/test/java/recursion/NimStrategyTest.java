package recursion;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Date: 2013.05.26. Time: 14:43
 */
public class NimStrategyTest {

    private NimStrategy nim;

    @Before
    public void setUp() {
        nim = new NimStrategy();
    }

    @Test
    // @Ignore
    public void test2() {
        int actual = nim.findGoodMove(2);
        assertTrue(actual > 0);
    }

    @Test
    // @Ignore
    public void test3() {
        int actual = nim.findGoodMove(3);
        assertTrue(actual > 0);
    }

    @Test
    // @Ignore
    public void test4() {
        int actual = nim.findGoodMove(4);
        assertThat(actual > 0, equalTo(true));
    }

    @Test
    // @Ignore
    public void test5() {
        int actual = nim.findGoodMove(5);
        assertFalse(actual > 0);
    }

    @Test
    // @Ignore
    public void testloop() {

        for (int i = 2; i <= 21; i++) {

            int actual = nim.findGoodMove(i);
            // assertThat("Iteration: " + i, actual > 0, equalTo(true));
            System.out.println("Iteration: " + i + " is " + (actual > 0 ? " OK" : "BAD") + " actual:" + actual);
        }

    }
}
