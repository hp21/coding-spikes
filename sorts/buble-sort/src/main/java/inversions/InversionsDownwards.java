package inversions;

import api.IInversion;

/**
 * Created by hp21 on 2016.07.19..
 */
public class InversionsDownwards implements IInversion {

    private int[] inversionVector;

    @Override
    public int inversions(final int[] array) {

        if (array == null || array.length < 1) {
            inversionVector = new int[]{};
            return 0;
        }

        int[] vector = new int[array.length];

        int inversions = 0;

        for (int outer = array.length - 1; outer >= 1; outer--) {

            int inversionsForElement = 0;

            for (int inner = outer - 1; inner >= 0; inner--) {
                if (array[inner] > array[outer]) {
                    inversions++;
                    inversionsForElement++;
                }
            }

            vector[array[outer] - 1] = inversionsForElement;


        }

        inversionVector = vector;

        return inversions;
    }

    /**
     * Works only if permutation is in range [1....n], consecutive
     *
     * @return
     */
    @Override
    public int[] vector() {
        return inversionVector == null ? new int[]{} : inversionVector;
    }
}
