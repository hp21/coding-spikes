package recursion;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * Date: 2013.05.27. Time: 12:14
 */
public class EvenOddTest {

    private EvenOdd service;

    @Before
    public void setUp() {
        service = new EvenOdd();
    }

    @Test
    public void test0() {
        final boolean actual = service.isEven(0);
        assertThat(actual, equalTo(true));

        final boolean actual1 = service.isOdd(0);
        assertThat(actual1, equalTo(false));
    }

    @Test
    public void test1() {
        final boolean actual = service.isOdd(1);
        assertThat(actual, equalTo(true));

        final boolean actual1 = service.isEven(1);
        assertThat(actual1, equalTo(false));
    }

    @Test
    public void test2() {
        final boolean actual = service.isEven(2);
        assertThat(actual, equalTo(true));

        final boolean actual1 = service.isOdd(2);
        assertThat(actual1, equalTo(false));
    }

}
