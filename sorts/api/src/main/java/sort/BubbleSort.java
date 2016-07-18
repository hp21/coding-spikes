package sort;

import api.ISort;

/**
 * Created by P.Horvath on 2016.07.18..
 */
public class BubbleSort implements ISort {

    ThreadLocal<Integer> inversions = new InheritableThreadLocal<>();

    public BubbleSort() {
       inversions.set(0);
    }

    @Override
    public int[] sort(final int[] array) {

        if (array == null || array.length == 0 || array.length == 1) {
            return array;
        }


        for (int cycle = 0; cycle < array.length - 1; cycle++) {

            for (int i = 0; i < (array.length - (1 + cycle)); i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
        }


        return array;
    }

    private void swap(final int[] array, final int i, final int i1) {
        int temp = array[i];
        array[i] = array[i1];
        array[i1] = temp;

        inversions.set(inversions.get() + 1);
    }

    @Override
    public int getInversions() {
        return inversions.get();
    }
}
