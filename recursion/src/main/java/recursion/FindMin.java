package recursion;

/**
 * Created with IntelliJ IDEA. User: hp21 Date: 2013.05.23. Time: 15:45 To
 * change this template use File | Settings | File Templates.
 */
public class FindMin {

    // returns the minimum element in a[]
    public int findmin(int a[], int n) {

        if (n == 1) {
            return a[0];
        }

        // int min = Math.min(a[n - 1], findmin(a, n - 1));
        int arrayMin = findmin(a, n - 1);
        int min = a[n - 1] < arrayMin ? a[n - 1] : arrayMin;

        return min;

    }
}
