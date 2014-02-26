package ls58;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by hp21 on 2014.02.16..
 */
public class PermutationTest {

    private Permutation permutation;

    @Before
    public void setUp() throws Exception {
        permutation = new Permutation();

    }

    @Test
    public void testPermute() throws Exception {
        permutation.permute(new int[] { 2, 3,4, 5 }, 0);
    }
}
