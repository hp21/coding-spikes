package substr;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by hp21 on 2014.11.05..
 */
public class CommonSubstring2 implements ILongestSubstring {

    @Override
    public String longestSubstring(String text, String pattern) {

        final int textLength = text.length();
        final String[] suffixes = new String[textLength];

        for (int i = 0; i < textLength; i++) {
                 suffixes[textLength-i-1] = text.substring(i,textLength);
        }

        Arrays.sort(suffixes);

        findIndex(suffixes,pattern.charAt(0));

        for (int i = 0; i < textLength; i++) {
            System.out.println(suffixes[i]);
        }

        return null;
    }

    private int findIndex(String[] suffixes, char c) {
//        int = -1;
          return 0;



    }
}
