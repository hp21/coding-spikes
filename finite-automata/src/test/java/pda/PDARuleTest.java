package pda;

import java.util.Arrays;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created User: Peter Horvath/hp21 Date: 2013.07.09. Time: 13:27
 */
public class PDARuleTest {

    @Test
    public void test1() throws Exception {
        final PDARule rule = new PDARule(new PDAState("1"), '(', new PDAState("2"), '$', Arrays.asList('b', '$'));
        Assert.assertThat(rule.getState().getStateCode(), CoreMatchers.equalTo("1"));
    }
}
