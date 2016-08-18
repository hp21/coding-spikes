package substr;

import prefix.LongestPrefix;

import java.util.Arrays;

/**
 * Created by hp21 on 2014.11.05..
 */
public class CommonSubstring2 implements ILongestSubstring2 {

    private LongestPrefix prefix = new LongestPrefix();

    private boolean debug = false;

    @Override
    public String longestSubstring(String text) {

        final int textLength = text.length();
        final String[] suffixes = new String[textLength];

        for (int i = 0; i < textLength; i++) {
            suffixes[textLength - i - 1] = text.substring(i, textLength);
        }

        Arrays.sort(suffixes);

        for (int i = 0; i < textLength; i++) {
            System.out.println(suffixes[i]);
        }

        if (debug) {
            return "";
        }

        int maxLen = 0;
        int suffixIndex = -1;

        for (int i = 0; i < textLength - 1; i++) {
            int len = prefix.longestPrefix(suffixes[i], suffixes[i + 1]);
            if (len > maxLen) {
                maxLen = len;
                suffixIndex = i;
            }
        }


        return maxLen > 0 ? suffixes[suffixIndex].substring(0, maxLen) : "";
    }

}
