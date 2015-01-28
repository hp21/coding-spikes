package problem1;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Euler1Test {

    private Euler1 euler1;

    @Before
    public void setUp() {
        euler1 = new Euler1();
    }

    @Test
    public void testCreateSum_Zero() throws Exception {
        final long actual = euler1.createSum(0);
        assertThat(actual, CoreMatchers.is(0L));
    }

    @Test
    public void testCreateSum_3() throws Exception {
        final long actual = euler1.createSum(3);
        assertThat(actual, CoreMatchers.is(3L));
    }

    @Test
    public void testCreateSum_5() throws Exception {
        final long actual = euler1.createSum(5);
        assertThat(actual, CoreMatchers.is(8L));
    }

    @Test
    public void testCreateSum_10() throws Exception {
        final long actual = euler1.createSum(10);
        assertThat(actual, CoreMatchers.is(33L));
    }

    @Test
    public void testCreateSum_15() throws Exception {
        final long actual = euler1.createSum(15);
        assertThat(actual, CoreMatchers.is(60L));
    }

    @Test
    public void testCreateSum_16() throws Exception {
        final long actual = euler1.createSum(18);
        assertThat(actual, CoreMatchers.is(78L));
    }
}