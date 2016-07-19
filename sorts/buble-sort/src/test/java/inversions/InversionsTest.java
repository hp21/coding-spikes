package inversions;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by u292148 on 2016.07.19..
 */
public class InversionsTest {


    private InversionsDownwards inversions;

    @Before
    public void setUp() throws Exception {
        inversions = new InversionsDownwards();

    }

    @Test
    public void inversionsWithNullOrEmptyOr1Elemement() throws Exception {

        int[] tested = null;

        int actual = this.inversions.inversions(tested);
        Assert.assertThat(actual, CoreMatchers.is(0));

        tested = new int[]{};
        actual = this.inversions.inversions(tested);
        Assert.assertThat(actual, CoreMatchers.is(0));

        tested = new int[]{5};
        actual = this.inversions.inversions(tested);
        Assert.assertThat(actual, CoreMatchers.is(0));

    }

    @Test
    public void inversionsWithElementsNoInversion() throws Exception {

        int[] tested = new int[]{1};

        int actual = this.inversions.inversions(tested);
        Assert.assertThat(actual, CoreMatchers.is(0));

        tested = new int[]{1, 2};
        actual = this.inversions.inversions(tested);
        Assert.assertThat(actual, CoreMatchers.is(0));

        tested = new int[]{1, 2, 3, 40, 50, 65, 70};
        actual = this.inversions.inversions(tested);
        Assert.assertThat(actual, CoreMatchers.is(0));
    }

    @Test
    public void inversionsWithElementsWithInversion() throws Exception {

        int[] tested = new int[]{4, 2};
        int actual = this.inversions.inversions(tested);
        Assert.assertThat(actual, CoreMatchers.is(1));

        tested = new int[]{3, 2, 1};
        actual = this.inversions.inversions(tested);
        Assert.assertThat(actual, CoreMatchers.is(3));

        tested = new int[]{3, 1, 4, 2};
        actual = this.inversions.inversions(tested);
        Assert.assertThat(actual, CoreMatchers.is(3));

        tested = new int[]{6, 5, 4, 3, 2, 1};
        actual = this.inversions.inversions(tested);
        Assert.assertThat(actual, CoreMatchers.is(15));
    }

}