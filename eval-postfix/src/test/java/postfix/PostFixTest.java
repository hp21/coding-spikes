package postfix;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class PostFixTest {

    private PostFix postfix;

    @Before
    public void setUp() {
        postfix = new PostFix();
    }

    @Test
    public void test1() {
        final long actual = postfix.eval("6");
        assertThat(actual, equalTo(6L));
    }

    @Test
    public void test2() {

        long actual = postfix.eval("6 2 +");
        assertThat(actual, equalTo(8L));

        actual = postfix.eval("6 2 -");
        assertThat(actual, equalTo(4L));

        actual = postfix.eval("-6 2 -");
        assertThat(actual, equalTo(-8L));

        actual = postfix.eval("6 2 *");
        assertThat(actual, equalTo(12L));

        actual = postfix.eval("6 2 /");
        assertThat(actual, equalTo(3L));
    }

    @Test
    public void test3() {

        long actual = postfix.eval("6 2 3 + +");
        assertThat(actual, equalTo(11L));

        actual = postfix.eval("6 2 3 - -");
        assertThat(actual, equalTo(7L));

        actual = postfix.eval("6 2 3 * *");
        assertThat(actual, equalTo(36L));

        actual = postfix.eval("8 2 3 * +");
        assertThat(actual, equalTo(14L));

    }

    @Test
    public void test4() {

        long actual = postfix.eval("2 4 5 6 + + +");
        assertThat(actual, equalTo(17L));

    }

    public void testIsNumberMethod() throws Exception {
        Method method = getMethod("isNumber");

        boolean actual = (Boolean) method.invoke("12");
        assertThat(actual, equalTo(true));

        actual = (Boolean) method.invoke("-12");
        assertThat(actual, equalTo(true));

    }

    private Method getMethod(String methodName) {
        final Method[] declaredMethods = postfix.getClass().getDeclaredMethods();

        Method method = null;

        for (Method m : declaredMethods) {
            if (methodName.equals(m.getName())) {
                method = m;
            }
        }
        return method;
    }

}
