package bubble;

import api.ISort;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Bubble implements ISort {


    @Override
    public int[] sort(int[] array) {

        if (array.length < 2) {
            return array;
        }


        for (int z = 1; z < array.length; z++) {

            int value = array[z];

           /*
            int before = z - 1;

            while (before >= 0 && value < array[before]) {
                array[before + 1] = array[before];
                before--;
            }

            array[before + 1] = value;
*/
            int before;

            for (before = z - 1; before >= 0; before--) {
                if (value < array[before]) {
                    //move up
                    array[before + 1] = array[before];
                } else {
                    break;
                }
            }

            array[before + 1] = value;

        }


        return array;
    }

    @Override
    public int getInversions() {
        throw new NotImplementedException();
//        return 0;
    }
}
