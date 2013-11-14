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

}
