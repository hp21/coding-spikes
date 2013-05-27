package recursion;

/**
 * Date: 2013.05.27. Time: 12:12
 */
public class EvenOdd {

    public EvenOdd() {
    }

    /*
     * public boolean isEven(int n) { boolean status;
     * 
     * if (n == 0) { status = true; return status; } else { status = isOdd(n -
     * 1); return status; } }
     * 
     * public boolean isOdd(int n) { boolean status = false;
     * 
     * if (n == 0) { status = false; return status; } else { status = isEven(n -
     * 1); return status; } }
     */

    public boolean isEven(int n) {
        return n == 0 ? true : isOdd(n - 1);

    }

    public boolean isOdd(int n) {

        return n == 0 ? false : isEven(n - 1);
    }
}
