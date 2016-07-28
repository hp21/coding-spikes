package codility.binarygap;

/**
 * Created by hp21 on 2016.01.29..
 */
public class Solution3 {


    public int solution(int N) {

        if (N < 0) {
            return 0;
        }

        int zeroGap = 0;
        int zeros = 0;

        String strn = Integer.toBinaryString(N);
        int pos = 0;

        String st = next(strn, pos);
        pos++;

        while (st != null && st.equals("1")) {
            st = next(strn, pos);
            pos++;
        }

        while (st != null && st.equals("0")) {
            zeros++;
            st = next(strn, pos);
            pos++;
        }

        while (st != null) {

            switch (st) {
                case "0":
                    zeros++;
                    break;

                case "1":
                    zeroGap = zeros > zeroGap ? zeros : zeroGap;
                    zeros = 0;
                    break;
            }

            st = next(strn, pos);
            pos++;
        }

        return zeroGap;
    }


    private String next(String strn, int pos) {
        return pos < strn.length() ? strn.substring(pos, pos + 1) : null;
    }
}
