package postfix;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * Date: 2013.06.06. Time: 17:11
 */
public class InfixToPostFixFullTest {

    private InfixToPostFixFull converter;

    @Before
    public void setUp() throws Exception {
        converter = new InfixToPostFixFull();
    }

    @Test
    public void test2() throws Exception {
        final String actual = converter.infixToPostfix("2 + 3");
        assertThat(actual, equalTo("2 3 +"));
    }
}
