package pda;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Created User: Peter Horvath/hp21 Date: 2013.07.09. Time: 13:04
 */
public class PDAStackTest {

    @Test
    public void testEmptyStack() throws Exception {
        final PDAStack stack = new PDAStack();

        assertThat(stack.isEmpty(), equalTo(true));

    }

    @Test
    public void testPushPopStack() throws Exception {
        final PDAStack stack = new PDAStack('1', '2', '3', '4');

        assertThat(stack.pop(), equalTo('4'));
        assertThat(stack.size(), equalTo(3));

        assertThat(stack.peek(), equalTo('3'));
        assertThat(stack.size(), equalTo(3));

        stack.push('9');
        assertThat(stack.pop(), equalTo('9'));
        assertThat(stack.size(), equalTo(3));

    }

}
