package factorial;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA. User: u292148 Date: 2013.05.07. Time: 17:30 To
 * change this template use File | Settings | File Templates.
 */
public class FactorialTest {

    private FactorialRecurse factorial;

    @Before
    public void setUp() {
        factorial = new FactorialRecurse();
    }

    @Test
    public void test0() {
        final long actual = factorial.fact(0L);
        assertThat(actual, is(1L));
    }

    @Test
    public void test1() {
        final long actual = factorial.fact(1L);
        assertThat(actual, is(1L));
    }

    @Test
    public void test2() {
        final long actual = factorial.fact(2L);
        assertThat(actual, is(2L));
    }

    @Test
    public void test5() {
        final long actual = factorial.fact(5L);
        assertThat(actual, is(120L));
    }

    @Test
    public void test6() {
        final int n = 29;
        final long start = System.currentTimeMillis();
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        final long actual = factorial.fact(n);
        final long end = System.currentTimeMillis();

        assertThat(actual, not(0L));
        System.out.println("actual: " + actual);
        System.out.println(((double) end - (double) start) / 1000.0);

    }

}
