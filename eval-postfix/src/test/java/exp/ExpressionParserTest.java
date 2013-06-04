package exp;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

/**
 * Date: 2013.06.04. Time: 19:27
 */
public class ExpressionParserTest {

    @Before
    public void setUp() {

    }

    @Test
    public void parseIntegerTest() {
        ExpressionParser parser = new ExpressionParser("6 ");
        final long actual = parser.parse();
        assertThat(actual, equalTo(6L));
    }

    @Test
    public void nextTokenTest() throws Exception {
        ExpressionParser parser = new ExpressionParser("6 + 2 * 4");

        final Method tokenMethod = getMethod(parser, "nextToken");

        String actual = (String) tokenMethod.invoke(parser);
        assertThat(actual, equalTo("6"));

        actual = (String) tokenMethod.invoke(parser);
        assertThat(actual, equalTo("+"));

        actual = (String) tokenMethod.invoke(parser);
        assertThat(actual, equalTo("2"));

        actual = (String) tokenMethod.invoke(parser);
        assertThat(actual, equalTo("*"));

        actual = (String) tokenMethod.invoke(parser);
        assertThat(actual, equalTo("4"));

    }

    @Test
    public void parseTwoTestPlusMinus() {
        ExpressionParser parser = new ExpressionParser("6 + 2");
        long actual = parser.parse();
        assertThat(actual, equalTo(8L));

        parser = new ExpressionParser("6 - 2");
        actual = parser.parse();
        assertThat(actual, equalTo(4L));
    }

    @Test
    public void parseTwoTestMultDiv() {
        ExpressionParser parser = new ExpressionParser("6 * 2");
        long actual = parser.parse();
        assertThat(actual, equalTo(12L));

        parser = new ExpressionParser("24 / 3");
        actual = parser.parse();
        assertThat(actual, equalTo(8L));
    }


    private Method getMethod(ExpressionParser parser, String methodName) {
        final Method[] declaredMethods = parser.getClass().getDeclaredMethods();

        Method method = null;

        for (Method m : declaredMethods) {
            if (methodName.equals(m.getName())) {
                method = m;
            }
        }
        return method;
    }

}
