package bubble;

import api.ISort;

public class Bubble implements ISort {


    @Override
    public int[] sort(int[] array) {

        if (array.length < 2) {
            return array;
        }


        for (int z = 1; z < array.length; z++) {

            int value = array[z];

            for (int before = z - 1; before >= 0; before--) {
                if (value < array[before]) {
                    //move up
                    array[before + 1] = array[before];
                    array[before] = value;
                } else {
                    break;
                }
            }

        }


        return array;
    }
}
