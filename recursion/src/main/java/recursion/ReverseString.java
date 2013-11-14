package recursion;

/**
 * User: hp21 Date: 2013.11.14. Time: 14:59
 */
public class ReverseString {

    public String reverse(String str) {

        if (str == null) {
            return null;
        }

        final char[] origChars = str.toCharArray();

//        reverse1(origChars, 0, origChars.length - 1);
        reverse(origChars, 0, origChars.length - 1);

        return String.valueOf(origChars);
    }

    private void reverse(char[] origChars, int low, int high) {

        if (high <= low) {
            return;
        }

        char temp = origChars[low];
        origChars[low] = origChars[high];
        origChars[high] = temp;
        reverse(origChars, low + 1, high - 1);
    }

    private void reverse1(char[] origChars, int lo, int hi) {

        for (int low = lo, high = hi; lo < hi; low++, high--) {
            char tmp = origChars[high];
            origChars[low] = origChars[high];
            origChars[high] = tmp;
        }
    }

}

