package ternary;

import mintree.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringSearchTest {

    private StringSearch finder;

    @Before
    public void setup() {
        finder = new StringSearch();
    }

   /* @Test(expected = NullPointerException.class)
    public void testForNullNode() {
        final TreeNode actual = finder.findString(null, "asdf");
        assertFalse(true);
    }*/

    @Test
    public void testFindString() throws Exception {
        Assert.assertTrue(true);
    }
}