package simplecalc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA. User: hp21 Date: 2013.05.08. Time: 8:40 To
 * change this template use File | Settings | File Templates.
 */
public class SimpleCalcTester {

    private SimpleCalculator calcualtor;

    @Before
    public void setUp() {
        calcualtor = new SimpleCalculator();
    }

    @Test
    public void testCreate() {

        assertThat(calcualtor, CoreMatchers.<SimpleCalculator> notNullValue());
    }

    @Test
    public void testSingleDigitTerm() {

        int value = calcualtor.parse("0");
        assertThat(value, is(0));
    }

    @Test
    public void testParentSingleDigitTerm() {

        int value = calcualtor.parse("(5)");
        assertThat(value, is(0));
    }


    @Test
    public void testParentDoubleDigitTerm() {

        int value = calcualtor.parse("((9))");
        assertThat(value, is(0));
    }

    @Test
    @Ignore
    //The grammer have problems!!
    public void testDoubleParentDoubleDigitTerm() {

        int value = calcualtor.parse("((4)-5+7)");
        assertThat(value, is(0));
    }

    @Test
    public void testParentBinaryAdd() {

        int value = calcualtor.parse("2+4");
        assertThat(value, is(0));
    }

    @Test
    public void testParentBinaryAdd1() {

        int value = calcualtor.parse("(2)+4");
        assertThat(value, is(0));

        value = calcualtor.parse("2+(4)");
        assertThat(value, is(0));

        value = calcualtor.parse("2+4");
        assertThat(value, is(0));
    }

}
