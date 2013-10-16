package count.string;

/**
 * Created with IntelliJ IDEA. User: hp21 Date: 2013.10.16. Time: 21:03
 */
public class StringCounter {

    public StringCounter() {
    }

    public String count(String str) {
        String ret = "";

        String prevString = "";
        int prevCount = 0;

        for (int i = 0; i < str.length(); i++) {
            String chr = str.substring(i, i + 1);

            if (prevString.equals(chr)) {
                prevCount++;
                continue;
            }

            if (firstCharacter(prevString)) {
                prevString = chr;
                prevCount++;
            } else {
                ret = addToReturn(ret, prevString, prevCount);
                prevString = chr;
                prevCount = 1;
            }
        }

        // dump remaining
        if (!firstCharacter(prevString)) {
            ret = addToReturn(ret, prevString, prevCount);
        }

        return ret;
    }

    private String addToReturn(String ret, String prevString, int prevCount) {
        ret = ret + dumpValue(prevString, prevCount);
        return ret;
    }

    private boolean firstCharacter(String prevStirng) {
        return prevStirng.length() == 0;
    }

    private String dumpValue(String prevString, int prevCount) {
        return prevString + "/" + prevCount;
    }

}