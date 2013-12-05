package t1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * User: hp21 Date: 2013.12.05. Time: 13:08
 */
public class ReplaceBlankTest {

    public static final String HELLO = "hello";
    private static final String WORLD = "world";
    private static final String SPACE = " ";
    public static final String SPACE_20 = "%20";
    ReplaceBlank replaceBlank;

    @Before
    public void setUp() {
        replaceBlank = new ReplaceBlank();
    }

    @Test
    public void nullTest() {
        final char[] actual = replaceBlank.replace(null);
        assertThat(actual, nullValue());
    }

    @Test
    public void emptyTest() {
        final char[] actual = replaceBlank.replace(new char[] {});
        assertThat(actual.length, equalTo(0));
    }

    @Test
    public void withNoSpaceTest() {

        char[] bigCharArray = convertStringTocharArray(HELLO);

        final char[] actual = replaceBlank.replace(bigCharArray);
        assertThat(check(actual, HELLO.toCharArray()), equalTo(true));

    }

    @Test
    public void withOneSpaceTest() {

        final String myString = HELLO + SPACE + WORLD;
        char[] bigCharArray = convertStringTocharArray(myString);

        final char[] actual = replaceBlank.replace(bigCharArray);
        assertThat("Actual: " + String.valueOf(actual), check(actual, ("" + HELLO + SPACE_20 + WORLD).toCharArray()), equalTo(true));
    }

    @Test
    public void withTwoSpaceTest() {

        final String myString = HELLO + SPACE + WORLD + HELLO + SPACE + WORLD;
        char[] bigCharArray = convertStringTocharArray(myString);

        final char[] actual = replaceBlank.replace(bigCharArray);
        assertThat("Actual: " + String.valueOf(actual),
                check(actual, ("" + HELLO + SPACE_20 + WORLD + HELLO + SPACE_20 + WORLD).toCharArray()), equalTo(true));
    }

    @Test
    public void withTwoConsequtiveSpaceaTest() {

        final String myString = HELLO + SPACE + SPACE + WORLD;
        char[] bigCharArray = convertStringTocharArray(myString);

        final char[] actual = replaceBlank.replace(bigCharArray);
        assertThat("Actual: " + String.valueOf(actual), check(actual, ("" + HELLO + SPACE_20 + SPACE_20 + WORLD).toCharArray()),
                equalTo(true));
    }

    @Test
    public void withJustOneSpaceTest() {

        final String myString = SPACE;
        char[] bigCharArray = convertStringTocharArray(myString);

        final char[] actual = replaceBlank.replace(bigCharArray);
        assertThat("Actual: " + String.valueOf(actual), check(actual, ("" + SPACE_20).toCharArray()), equalTo(true));
    }

    @Test
    public void withTrailingSpaceTest() {

        final String myString = HELLO + SPACE;
        char[] bigCharArray = convertStringTocharArray(myString);

        final char[] actual = replaceBlank.replace(bigCharArray);
        assertThat("Actual: " + String.valueOf(actual), check(actual, (HELLO + SPACE_20).toCharArray()), equalTo(true));
    }

    @Test
    public void bigSpaceTest() {

        final String myString = SPACE + SPACE + HELLO + SPACE + SPACE + WORLD + SPACE + SPACE;
        char[] bigCharArray = convertStringTocharArray(myString);

        final char[] actual = replaceBlank.replace(bigCharArray);
        assertThat("Actual: " + String.valueOf(actual),
                check(actual, (SPACE_20 + SPACE_20 + HELLO + SPACE_20 + SPACE_20 + WORLD + SPACE_20 + SPACE_20).toCharArray()),
                equalTo(true));
    }

    private boolean check(char[] actual, char[] expected) {
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual[i]) {
                return false;
            }
        }

        return true;
    }

    private char[] convertStringTocharArray(String str) {
        final char[] bigCharArray = new char[52];

        int i;
        for (i = 0; i < str.length(); i++) {
            bigCharArray[i] = str.charAt(i);
        }

        bigCharArray[i] = Character.toChars(0)[0];

        return bigCharArray;
    }
}
