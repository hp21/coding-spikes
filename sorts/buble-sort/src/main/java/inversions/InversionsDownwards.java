package inversions;

import api.IInversion;

/**
 * Created by u292148 on 2016.07.19..
 */
public class InversionsDownwards implements IInversion {

    @Override
    public int inversions(final int[] array) {

        if (array == null || array.length <= 1) {
            return 0;
        }

        int inversions = 0;

        for (int outer = array.length - 1; outer >= 1; outer--) {

            for (int inner = outer - 1; inner >= 0; inner--) {
                if (array[inner] > array[outer]) {
                    inversions++;
                }
            }

        }

        return inversions;
    }
}
