package exp;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tree.Node;

import com.google.common.base.Strings;

/**
 * Date: 2013.06.04. Time: 21:10
 */
public class ExpressionParserTreeBuilderTest {

    @Test
    public void testOne() {

        ExpressionParserTreeBuilder parser = new ExpressionParserTreeBuilder("6");

        Node<String> actual = parser.parse();
        assertThat(actual.getData(), equalTo("6"));

    }

    @Test
    public void testTwoPLusMinus() {

        ExpressionParserTreeBuilder parser = new ExpressionParserTreeBuilder("6 + 2");

        Node<String> actual = parser.parse();
        assertThat(actual.getData(), equalTo("+"));

        assertThat(actual.getLeft().getData(), equalTo("6"));
        assertThat(actual.getRight().getData(), equalTo("2"));

        parser = new ExpressionParserTreeBuilder("6 - 9");

        actual = parser.parse();
        assertThat(actual.getData(), equalTo("-"));

        assertThat(actual.getLeft().getData(), equalTo("6"));
        assertThat(actual.getRight().getData(), equalTo("9"));

    }

    @Test
    public void testThreePLusMinus() {

        ExpressionParserTreeBuilder parser = new ExpressionParserTreeBuilder("6 + 7 + 8");

        Node<String> actual = parser.parse();
        assertThat(actual.getData(), equalTo("+"));

        Node<String> left = actual.getLeft();
        final Node<String> right = actual.getRight();
        assertThat(left.getData(), equalTo("+"));

        assertThat(left.getLeft().getData(), equalTo("6"));
        assertThat(left.getRight().getData(), equalTo("7"));

        assertThat(right.getData(), equalTo("8"));

        printTree(actual, 0);

        /*
         * parser = new ExpressionParserTreeBuilder("6 - 9");
         * 
         * actual = parser.parse(); assertThat(actual.getData(), equalTo("-"));
         * 
         * assertThat(actual.getLeft().getData(), equalTo("6"));
         * assertThat(actual.getRight().getData(), equalTo("9"));
         */

    }

    private void printTree(Node<?> node, int level) {

        if (node == null) {
            return;
        }

        System.out.print(Strings.repeat(" ", 40- level));
        System.out.print("" + node.getData() + ((node.getData().equals("+")) ? "\n" : ""));
        printTree(node.getLeft(), (level + 1));
        printTree(node.getRight(), (level + 1));
 }
}
