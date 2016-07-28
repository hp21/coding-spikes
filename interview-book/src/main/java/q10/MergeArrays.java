package q10;

/**
 * Created by hp21 on 2013.12.11..
 */
public class MergeArrays {

    public int[] merge(int[] a1, int a1Len, int[] a2, int a2Len) {

        if (a1 == null || (a2 == null || a2Len == 0)) {
            return a1;
        }

        int last = a1Len + a2Len - 1;
        int a2Last = a2Len - 1;
        int a1Last = a1Len - 1;

        while (a1Last >= 0 && a2Last >= 0) {
            a1[last--] = a2[a2Last] > a1[a1Last] ? a2[a2Last--] : a1[a1Last--];
        }

        // handle remaining. only 1 'for' will run at max.
        // the other # must be zero
        for (; a1Last >= 0; a1Last--) {
            a1[last--] = a1[a1Last];
        }

        for (; a2Last >= 0; a2Last--) {
            a1[last--] = a2[a2Last];
        }

        return a1;

    }

}
