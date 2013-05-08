package simplecalc;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA. User: u292148 Date: 2013.05.08. Time: 8:40 To
 * change this template use File | Settings | File Templates.
 */
public class SimpleCalcTester {

    private SimpleCalcualtor calcualtor;

    @Before
    public void setUp() {
        calcualtor = new SimpleCalcualtor();
    }

    @Test
    public void testCreate() {

        assertThat(calcualtor, CoreMatchers.<SimpleCalcualtor> notNullValue());
    }

    @Test
    public void testSingleDigitTerm() {

        int value = calcualtor.parse("0");
        assertThat(value, is(0));
    }

}
