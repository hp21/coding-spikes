package recursion;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Date: 2013.06.10. Time: 12:26
 */
public class DiceTest {

    private Dice dice;

    @Before
    public void setUp() throws Exception {
        dice = new Dice(3);
    }

    @Test
    public void testThrowsDice() throws Exception {

        final List<Integer> actual = dice.throwDice();
        assertThat(actual, notNullValue());
        assertThat(actual.size(), equalTo(3));

        for (int value : actual) {
            assertThat("vaue: " + value, value >= 1, equalTo(true));
            assertThat("vaue: " + value, value <= 6, equalTo(true));
        }

        System.out.println(actual);

    }

    @Test
    public void testThrowsDice6() throws Exception {

        dice = new Dice(6);
        final List<Integer> actual = dice.throwDice();
        assertThat(actual, notNullValue());
        assertThat(actual.size(), equalTo(6));

        for (int value : actual) {
            assertThat("vaue: " + value, value >= 1, equalTo(true));
            assertThat("vaue: " + value, value <= 6, equalTo(true));
        }

        System.out.println(actual);

    }
}
