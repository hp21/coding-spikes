package mergesort;

import api.ISort;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by u292148 on 2016.07.28..
 */
public class MergeSort implements ISort {

    ExecutorService executor = Executors.newFixedThreadPool(20);

    private AtomicBoolean started = new AtomicBoolean(false);

    @Override
    public int[] sort(final int[] array) {

        if (array == null || array.length <= 1) {
            return array;
        }

        int[] result = mySort(array, 0, array.length - 1);

        executor.shutdownNow();
        return result;
    }

    private int[] mySort(final int[] array, final int low, final int high) {

        if (high == low) {
            return new int[]{array[low]};
        }

        int middle = (low + high) / 2;

        int[] lowPart;
        int[] highPart;

//        if (   !started.getAndSet(true)) {
        if (low == 0 && high == array.length - 1) {
            Callable<int[]> lowTask = () -> mySort(array, low, middle);
            Callable<int[]> highTask = () -> mySort(array, low, middle);

            Future<int[]> futureLow = executor.submit(lowTask);
            Future<int[]> futureHigh = executor.submit(highTask);

            try {
                lowPart = futureLow.get();
                highPart = futureHigh.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }

        } else {

            lowPart = mySort(array, low, middle);
            highPart = mySort(array, middle + 1, high);
        }


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
