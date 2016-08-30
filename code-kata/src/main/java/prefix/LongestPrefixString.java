package prefix;

/**
 * Created by U292148 on 2016.08.18..
 */
public class LongestPrefixString {

    private LongestPrefixLength prefixLength = new LongestPrefixLength();


    /**
     * Returns number of common prefix characters
     *
     * @param text1
     * @param text2
     * @return
     */
    public String longestPrefix(String text1, String text2) {

        int length = prefixLength.longestPrefixLength(text1, text2);
        return length == 0 ? "" : text1.substring(0, length);
    }

}
