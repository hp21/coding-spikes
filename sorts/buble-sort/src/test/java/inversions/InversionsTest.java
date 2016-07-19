package inversions;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

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
    public void inversionsWithNullOrEmptyOr1Element() throws Exception {

        int[] tested = null;

        int actual = this.inversions.inversions(tested);
        assertThat(actual, is(0));

        tested = new int[]{};
        actual = this.inversions.inversions(tested);
        assertThat(actual, is(0));

        tested = new int[]{5};
        actual = this.inversions.inversions(tested);
        assertThat(actual, is(0));

    }

    @Test
    public void inversionsWithElementsNoInversion() throws Exception {

        int[] tested = new int[]{1};

        int actual = this.inversions.inversions(tested);
        assertThat(actual, is(0));

        int[] actualVector = inversions.vector();
        assertThat(actualVector, notNullValue());
        assertThat(actualVector.length >= 1, is(true));
        assertThat(actualVector[0], is(0));


        tested = new int[]{1, 2};
        actual = this.inversions.inversions(tested);
        assertThat(actual, is(0));

        actualVector = inversions.vector();
        assertThat(actualVector.length >= 1, is(true));
        assertThat(actualVector[0], is(0));
        assertThat(actualVector[1], is(0));

        tested = new int[]{1, 2, 3, 4, 5, 6, 7};
        actual = this.inversions.inversions(tested);
        assertThat(actual, is(0));

        actualVector = inversions.vector();
        assertThat(actualVector.length >= 1, is(true));
        for (int z = 0; z < 6; z++) {
            assertThat(actualVector[z], is(0));
        }

        System.out.printf("90 Vector: %s\n", Arrays.toString(actualVector));
    }

    @Test
    public void inversionsWithElementsWithInversion() throws Exception {

        int[] tested = new int[]{4, 2};
        int actual = this.inversions.inversions(tested);
        assertThat(actual, is(1));

        int[] actualVector = inversions.vector();
        assertThat(actualVector.length >= 1, is(true));
        assertThat(actualVector[0], is(0));
        assertThat(actualVector[1], is(1));

        tested = new int[]{3, 2, 1};
        actual = this.inversions.inversions(tested);
        assertThat(actual, is(3));

        actualVector = inversions.vector();
        assertThat(actualVector.length >= 1, is(true));
        assertThat(actualVector[0], is(2));
        assertThat(actualVector[1], is(1));
        assertThat(actualVector[2], is(0));


        tested = new int[]{3, 1, 4, 2};
        actual = this.inversions.inversions(tested);
        assertThat(actual, is(3));

        actualVector = inversions.vector();
        assertThat(actualVector.length >= 1, is(true));
        assertThat(actualVector[0], is(1));
        assertThat(actualVector[1], is(2));
        assertThat(actualVector[2], is(0));
        assertThat(actualVector[3], is(0));


        tested = new int[]{6, 5, 4, 3, 2, 1};
        actual = this.inversions.inversions(tested);
        assertThat(actual, is(15));

        actualVector = inversions.vector();
        assertThat(actualVector.length >= 1, is(true));
        assertThat(actualVector[0], is(5));
        assertThat(actualVector[1], is(4));
        assertThat(actualVector[2], is(3));
        assertThat(actualVector[3], is(2));
        assertThat(actualVector[4], is(1));
        assertThat(actualVector[5], is(0));

        System.out.printf("100 Vector: %s\n", Arrays.toString(actualVector));

    }

    @Test
    public void testBookValue() {


        int[] tested = new int[]{5, 9, 1, 8, 2, 6, 4, 7, 3};
        int actual = this.inversions.inversions(tested);
        assertThat(actual, is(20));

        int[] actualVector = inversions.vector();
        assertThat(actualVector.length >= 1, is(true));
        assertThat(actualVector[0], is(2));
        assertThat(actualVector[1], is(3));
        assertThat(actualVector[2], is(6));
        assertThat(actualVector[3], is(4));
        assertThat(actualVector[4], is(0));
        assertThat(actualVector[5], is(2));
        assertThat(actualVector[6], is(2));
        assertThat(actualVector[7], is(1));
        assertThat(actualVector[8], is(0));

        System.out.printf("110 Vector: %s\n", Arrays.toString(actualVector));
    }

}