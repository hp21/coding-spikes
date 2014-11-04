package substr;

/**
 * Created by phorvath21 on 2014.11.04..
 * 
 * array hold match length. dynamic programming example for longest String. see
 * google search for java program.
 */
public class LongestSubstring {

    public String longestSubstring(String text, String pattern) {

        final int textLength = text.length();
        final int patternLength = pattern.length();

        int subStringLength = -1;
        int index = -1;

        final int[][] array = new int[patternLength][textLength];

        for (int row = 0; row < patternLength; row++) {
            for (int col = 0; col < textLength; col++) {
                if (pattern.charAt(row) == text.charAt(col)) {
                    final int newLen = row > 0 && col > 0 ? array[row - 1][col - 1] + 1 : 1;
                    array[row][col] = newLen;
                    if (newLen > subStringLength) {
                        subStringLength = newLen;
                        index = col;
                    }
                }
            }
        }

        System.out.printf("len: %d, index=%d\n", subStringLength, index);
        return subStringLength > -1 ? text.substring(index - subStringLength + 1, index + 1) : "";
    }
}
