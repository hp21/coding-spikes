package recursion;

/**
 * Created with IntelliJ IDEA. User: hp21 Date: 2013.05.31. Time: 12:56 To
 * change this template use File | Settings | File Templates.
 */
public class PalindRome {

    public PalindRome() {
    }

    public boolean isPalindrome(String s) {

        if ("".equals(s) || s.length() == 1) {
            return true;
        }

        // return (s.substring(0, 1).equals(s.substring(s.length() - 1,
        // s.length()))) ? isPalindrome(s.substring(1, s.length() - 1)) : false;
        return (s.charAt(0) == (s.charAt(s.length() - 1))) ? isPalindrome(s.substring(1, s.length() - 1)) : false;
    }

    public boolean isPalindrome1(String s, int start, int end) {

        if (start >= end) {
            return true;
        }

        return (s.charAt(start) == s.charAt(end)) ? isPalindrome1(s, start + 1, end - 1) : false;
    }

}
