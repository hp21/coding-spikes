package postfix;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import tree.Node;

/**
 * Date: 2013.06.02. Time: 12:59
 */
public class BuildTreePostFixTest {

    private BuildTreePostFix postfix;

    @Before
    public void setUp() {
        postfix = new BuildTreePostFix();
    }

    @Test
    public void buildTreeTest1() {
        final Node<String> actual = postfix.buildTree("6");
        assertThat(actual.getData(), equalTo("6"));
        assertThat(actual.getLeft(), nullValue());
        assertThat(actual.getRight(), nullValue());

        assertThat(postfix.evaluate(actual), equalTo(6L));
    }

    @Test
    public void buildTreeTest2() {
        final Node<String> actual = postfix.buildTree("6 7 +");
        assertThat(actual.getData(), equalTo("+"));
        assertThat(actual.getLeft().getData(), equalTo("6"));
        assertThat(actual.getRight().getData(), equalTo("7"));

        assertThat(postfix.evaluate(actual), equalTo(13L));
    }

    @Test
    public void buildTreeTest2Mult() {
        final Node<String> actual = postfix.buildTree("6 7 *");
        assertThat(actual.getData(), equalTo("*"));
        assertThat(actual.getLeft().getData(), equalTo("6"));
        assertThat(actual.getRight().getData(), equalTo("7"));

        assertThat(postfix.evaluate(actual), equalTo(42L));
    }

    @Test
    public void buildTreeTest3() {
        final Node<String> actual = postfix.buildTree("6 7 8 + -");
        assertThat(actual.getData(), equalTo("-"));

        // left
        assertThat(actual.getLeft().getData(), equalTo("6"));
        assertThat(actual.getLeft().getLeft(), nullValue());
        assertThat(actual.getLeft().getRight(), nullValue());

        // right
        assertThat(actual.getRight().getData(), equalTo("+"));
        assertThat(actual.getRight().getLeft().getData(), equalTo("7"));
        assertThat(actual.getRight().getRight().getData(), equalTo("8"));

        assertThat(postfix.evaluate(actual), equalTo(-9L));
    }

}
