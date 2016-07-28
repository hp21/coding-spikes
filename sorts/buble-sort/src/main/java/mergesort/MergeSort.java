package mergesort;

import api.ISort;

/**
 * Created by u292148 on 2016.07.28..
 */
public class MergeSort implements ISort {

    @Override
    public int[] sort(final int[] array) {

        if (array == null || array.length <= 1) {
            return array;
        }

        return mySort(array, 0, array.length - 1);
    }

    private int[] mySort(final int[] array, final int low, final int high) {

        if (high == low) {
            return new int[]{array[low]};
        }

        int middle = (low + high) / 2;

        int[] lowPart = mySort(array, low, middle);
        int[] highPart = mySort(array, middle + 1, high);

        return merge(lowPart, highPart);
    }

    private int[] merge(final int[] lowPart, final int[] highPart) {

        int[] sortedArray = new int[lowPart.length + highPart.length];

        int low = 0, high = 0, z = 0;

        while (low < lowPart.length && high < highPart.length) {
            sortedArray[z++] = lowPart[low] <= highPart[high] ? lowPart[low++] : highPart[high++];
        }

        //merge remaining items
        while (low < lowPart.length) {
            sortedArray[z++] = lowPart[low++];
        }

        while (high < highPart.length) {
            sortedArray[z++] = highPart[high++];
        }

        return sortedArray;
    }


    @Override
    public int getInversions() {
        return 0;
    }
}
