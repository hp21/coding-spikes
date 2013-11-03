package mintree;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * User: hp21 Date: 2013.11.02. Time: 15:35
 */
public class TreeAlgTest {

    private TreeAlg treeAlg;

    @Before
    public void setup() {
        treeAlg = new TreeAlg();
    }

    @Test(expected = NullPointerException.class)
    public void testForNullArgument() {
        treeAlg.mintree(null);
    }

    @Test
    public void testOneEven() {

        TreeNode node1 = new TreeNode(2, null);
        final Integer actual = treeAlg.mintree(node1);

        assertThat(actual, nullValue());
    }

    @Test
    public void testOneOdd() {

        TreeNode node1 = new TreeNode(21, null);
        final Integer actual = treeAlg.mintree(node1);

        assertThat(actual, equalTo(21));
    }

    @Test
    public void test2() {

        TreeNode leaf = new TreeNode(1, null);
        TreeNode node1 = new TreeNode(2, null);
        node1.addNode(leaf);
        final int actual = treeAlg.mintree(node1);

        assertThat(actual, equalTo(1));
    }

    @Test
    public void test3() {

        TreeNode leaf1 = new TreeNode(5, null);
        TreeNode leaf2 = new TreeNode(1, null);
        TreeNode node1 = new TreeNode(2, null);
        node1.addNode(leaf1);
        node1.addNode(leaf2);
        final int actual = treeAlg.mintree(node1);

        assertThat(actual, equalTo(1));
    }

    @Test
    public void test4() {

        TreeNode leaf11 = new TreeNode(-1, null);
        TreeNode leaf1 = new TreeNode(5, null);
        leaf1.addNode(leaf11);
        TreeNode leaf2 = new TreeNode(1, null);
        TreeNode node1 = new TreeNode(2, null);
        node1.addNode(leaf1);
        node1.addNode(leaf2);
        final int actual = treeAlg.mintree(node1);

        assertThat(actual, equalTo(-1));
    }

    @Test
    public void test4_1() {

        TreeNode leaf11 = new TreeNode(11, null);
        TreeNode leaf1 = new TreeNode(5, null);
        leaf1.addNode(leaf11);
        TreeNode leaf2 = new TreeNode(3, null);
        TreeNode node1 = new TreeNode(2, null);
        node1.addNode(leaf1);
        node1.addNode(leaf2);
        final int actual = treeAlg.mintree(node1);

        assertThat(actual, equalTo(3));
    }

}
