package postfix;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * Date: 2013.06.02. Time: 18:18
 */
public class InfixToPostFixTest {

    private InfixToPostFix infixToPostFix;

    @Before
    public void setUp() {
        infixToPostFix = new InfixToPostFix();
    }

    @Test
    public void testOne() {
        final String actual = infixToPostFix.infixToPostfix("4");
        assertThat(actual, equalTo("4"));
    }

    @Test
    public void testTwo() {
        String actual = infixToPostFix.infixToPostfix("4 + 5");
        assertThat(actual, equalTo("4 5 +"));

        actual = infixToPostFix.infixToPostfix("3 * 2");
        assertThat(actual, equalTo("3 2 *"));

        actual = infixToPostFix.infixToPostfix("4 / 5");
        assertThat(actual, equalTo("4 5 /"));

        actual = infixToPostFix.infixToPostfix("4 - 5");
        assertThat(actual, equalTo("4 5 -"));

        actual = infixToPostFix.infixToPostfix("a + b * c - d");
        assertThat(actual, equalTo("a b c * + d -"));

        actual = infixToPostFix.infixToPostfix("a * b + 2");
        assertThat(actual, equalTo("a b * 2 +"));

      /*  actual = infixToPostFix.infixToPostfix("3 * (2 + 5)");
        assertThat(actual, equalTo("a b * 2 +"));*/
    }
}
