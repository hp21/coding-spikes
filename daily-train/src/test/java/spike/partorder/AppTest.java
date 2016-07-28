package spike.partorder;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest

{

    private CompartmentSupport compartmentHelper;

    @Before
    public void setup() {
        this.compartmentHelper = new CompartmentSupport(9, 4, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void seatTestWithNegative() {

        int seat = -2;
        compartmentHelper.computeCompartment(seat);
    }

    @Test
    public void seatTest() {

        int seat = 1;

        for (int i = 1; i <= 4; i++) {
            seat = i;
            int actual = compartmentHelper.computeCompartment(seat);
            assertThat(actual, equalTo(1));

        }

        for (int i = 5; i <= 8; i++) {
            seat = i;
            int actual = compartmentHelper.computeCompartment(seat);
            assertThat(actual, equalTo(2));
        }

        int actual = compartmentHelper.computeCompartment(33);
        assertThat(actual, equalTo(9));

        actual = compartmentHelper.computeCompartment(36);
        assertThat(actual, equalTo(9));

        actual = compartmentHelper.computeCompartment(36);
        assertThat(actual, equalTo(9));

    }

    @Test
    public void seatTestAfter() {

        int actual;

        actual = compartmentHelper.computeCompartment(37);
        assertThat(actual, equalTo(9));

        actual = compartmentHelper.computeCompartment(38);
        assertThat(actual, equalTo(9));

        actual = compartmentHelper.computeCompartment(53);
        assertThat(actual, equalTo(1));

        actual = compartmentHelper.computeCompartment(54);
        assertThat(actual, equalTo(1));

    }

    @Test
    public void variations() {
        int actual = compartmentHelper.variations(6, 6);
        assertThat(actual, equalTo(1));

        actual = compartmentHelper.variations(6, 5);
        assertThat(actual, equalTo(6));

    }

}
