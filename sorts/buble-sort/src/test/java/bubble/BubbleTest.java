package bubble;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

/**
 * Created User: Peter Horvath
 * Date: 2013.08.16. Time: 10:05
 */
public class BubbleTest {

    private Bubble bubble;

    @Before
    public void setUp() {
        bubble = new Bubble();
    }

    @Test
    public void test0() {

        int[] array = new int[]{};
        final int[] sorted = bubble.sort(array);

        assertThat(sorted.length, equalTo(0));
        assertThat(sorted, sameInstance(array));
    }

    @Test
    public void testWithSize1() {

        int[] array = new int[]{5};
        final int[] sorted = bubble.sort(array);

        assertThat(sorted[0], equalTo(5));

    }

    @Test
    public void testWithSize2NoSort() {

        int[] array = new int[]{5, 6};
        final int[] sorted = bubble.sort(array);

        assertThat(sorted[0], equalTo(5));
        assertThat(sorted[1], equalTo(6));
    }


    @Test
    public void testWithSize2AndSort() {

        int[] array = new int[]{6, 5};
        final int[] sorted = bubble.sort(array);

        assertThat(sorted[0], equalTo(5));
        assertThat(sorted[1], equalTo(6));
    }

    @Test
    public void testWithSizeNSort() {

        int[] array = new int[]{6, 5, 10, 2, 3, 4, 1, 22};
        final int[] sorted = bubble.sort(array);

        assertThat(sorted[0], equalTo(1));
        assertThat(sorted[1], equalTo(2));
        assertThat(sorted[2], equalTo(3));
        assertThat(sorted[3], equalTo(4));
        assertThat(sorted[4], equalTo(5));
        assertThat(sorted[5], equalTo(6));
        assertThat(sorted[6], equalTo(10));
        assertThat(sorted[7], equalTo(22));
    }

    public void testWithSizeNAndNoSort() {

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 10, 22};
        final int[] sorted = bubble.sort(array);

        assertThat(sorted[0], equalTo(1));
        assertThat(sorted[1], equalTo(2));
        assertThat(sorted[2], equalTo(3));
        assertThat(sorted[3], equalTo(4));
        assertThat(sorted[4], equalTo(5));
        assertThat(sorted[5], equalTo(6));
        assertThat(sorted[6], equalTo(10));
        assertThat(sorted[7], equalTo(22));
    }

}
