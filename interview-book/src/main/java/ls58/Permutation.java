package ls58;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp21 on 2014.02.16..
 * 
 * See: http://stackoverflow.com/questions/18398556/java-permutation-of-array
 */
public class Permutation {

    public void permute(int[] array, int k) // raw type, I know
    {
        for (int i = k; i < array.length; i++) {
            int temp;
            temp = array[i];
            array[i] = array[k];
            array[k] = temp;
            permute(array, k + 1);
            temp = array[i];
            array[i] = array[k];
            array[k] = temp;
        }

        if (k == array.length) {
            printArray(array);
        }
    }

    private void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }

        System.out.println();
    }
}
