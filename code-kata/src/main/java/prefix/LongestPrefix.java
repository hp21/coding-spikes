package prefix;

/**
 * Created by U292148 on 2016.08.18..
 */
public class LongestPrefix {

    /**
     * Returns number of common prefix characters
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestPrefix(String text1, String text2) {

        if (text1 == null || text2 == null || text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }

        int commonlength = Math.min(text1.length(), text2.length());

        for (int i = 0; i < commonlength; i++) {
            if (text1.charAt(i) != text2.charAt(i)) {
                return i;
            }
        }

        return commonlength;
    }

}
