package strcalc;

/**
 * Created with IntelliJ IDEA. User: hp21 Date: 2013.10.18. Time: 19:28
 */
public class StringCalculator {

    // private final Pattern pattern;

    public StringCalculator() {
        // pattern= Pattern.compile("(\\d+)((,|\\n)(\\d+))*");
    }

    public int add(String numbers) {

        int ret = 0;

        if (numbers == null || numbers.length() == 0) {
            return 0;
        }

        int prevIndex = -1;
        int index = numbers.indexOf(",", prevIndex);

        while (index > 0) {

            Integer first = Integer.valueOf(numbers.substring(prevIndex + 1, index));
            ret = ret + first;

            prevIndex = index;
            index = numbers.indexOf(",", index + 1);
        }

        ret = ret + Integer.valueOf(numbers.substring(prevIndex + 1, numbers.length()));

        return ret;
    }
}
