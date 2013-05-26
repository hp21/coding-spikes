package recursion;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Date: 2013.05.26. Time: 11:09
 */
public class FindInOrderedArrayTest {

    private FindInOrderedArray finder;

    @Before
    public void setUp() {
        finder = new FindInOrderedArray();
    }

    @Test
    public void findInEmpytArrayElement() {

        final int[] arr = {};
        final int actual = finder.find(arr, 21);
        Assert.assertThat(actual, equalTo(-1));
    }

    @Test
    public void findNotExistingElement() {

        final int[] arr = { 23 };
        final int actual = finder.find(arr, 21);
        Assert.assertThat(actual, equalTo(-1));
    }

    @Test
    public void findIn1Element() {

        final int[] arr = { 23 };
        final int actual = finder.find(arr, 23);
        Assert.assertThat(actual, equalTo(0));

        final int actual1 = finder.find(arr, -1);
        Assert.assertThat(actual1, equalTo(-1));
    }

    @Test
    public void findIn2Element() {

        final int[] arr = { 23,50 };
        final int actual = finder.find(arr, 23);
        Assert.assertThat(actual, equalTo(0));

        final int actual1 = finder.find(arr, 50);
        Assert.assertThat(actual1, equalTo(1));
    }

    @Test
    public void findIn5Element() {

        final int[] arr = { 23, 24, 55, 101,200,300,400,500,600};

        for (int i = 0; i < arr.length; i++) {
            final int actual = finder.find(arr, arr[i]);
            Assert.assertThat(actual, equalTo(i));
        }

        final int actual1 = finder.find(arr, -1);
        Assert.assertThat(actual1, equalTo(-1));
    }

}
