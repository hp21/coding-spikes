package ls58;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp21 on 2014.02.16..
 * 
 * See: http://stackoverflow.com/questions/18398556/java-permutation-of-array
 */
public class Permutation {

    public void permute(int[] array, int level) {

        // if past last element
        if (level == array.length) {
            printArray(array);
            return;
        }

        for (int i = level; i < array.length; i++) {
            int temp;
            temp = array[i];
            array[i] = array[level];
            array[level] = temp;
            permute(array, level + 1);
            temp = array[i];
            array[i] = array[level];
            array[level] = temp;
        }

    }

    private void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }

        System.out.println();
    }
}
