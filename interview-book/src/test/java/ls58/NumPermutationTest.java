package ls58;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by hp21 on 2014.02.16..
 */
public class NumPermutationTest {

    private NumPermutation permutation;

    @Before
    public void setUp() throws Exception {
        permutation = new NumPermutation();

    }

    @Test
    public void testPermute() throws Exception {

        permutation.permute(3);

    }
}
