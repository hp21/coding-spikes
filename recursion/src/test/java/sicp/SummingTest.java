package sicp;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SummingTest {

    private Summing summing;

    @Before
    public void setUp() throws Exception {
        summing = new Summing();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddIncrement() throws Exception {
        final int actual = summing.addIncrement(0, 3);
        Assert.assertEquals(actual,6);
    }

    @Test
    public void testAddSquare() throws Exception {
        final int actual = summing.addSquare(0, 3);
        Assert.assertEquals(actual,14);
    }

    @Test
    public void testAddGeneral() throws Exception {

    }

    @Test
    public void testAddIncrementNew() throws Exception {
        final int actual = summing.addIncrementNew(0, 3);
        Assert.assertEquals(actual,6);
    }

    @Test
    public void testAddSquareNew() throws Exception {
        final int actual = summing.addSquareNew(0, 3);
        Assert.assertEquals(actual,14);
    }
}