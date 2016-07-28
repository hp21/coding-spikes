package recursion;

/**
 * Created with IntelliJ IDEA. User: hp21 Date: 2013.05.26. Time: 11:09 To
 * change this template use File | Settings | File Templates.
 */
public class FindInOrderedArray {

    // / private int level;

    public FindInOrderedArray() {
    }

    /**
     * Returns the index of the element found
     * 
     * @param a
     * @param value
     * @return -1 if nou found
     */
    public int find(int[] a, int value) {
        // System.out.println("======================");
        // level = -1;
        return a.length == 0 ? -1 : findInternal(a, value, 0, a.length);

    }

    /**
     * 
     * 
     * 
     * @param a
     * @param value
     * @param low
     * @param high
     *            is the last index in the array
     * @return
     */
    private int findInternal(int[] a, int value, int low, int high) {

        // level++;
        // System.out.println("level: " + level);

        if (high < low) {
            return -1;
        }

        final int middle = (low + high) / 2;

        if (a[middle] == value) {
            return middle;
        }

        return (a[middle] > value) ? findInternal(a, value, low, middle - 1) : findInternal(a, value, middle + 1, high);

    }
}
