package codility.binarygap;

/**
 * Created by hp21 on 2016.01.29..
 */
public class Solution {

    int number;

    public int solution(int N) {

        if (N < 0) {
            return 0;
        }

        number = N;

        int zeroGap = 0;
        int zeros = 0;

        int nextDigit = nextDigit(number);

        //skip initial 0s, not bounded by 1
        while (number >= 0 && nextDigit == 0) {
            nextDigit = nextDigit(number);
        }

        //skip boundary 1s
        while (number >= 0 && nextDigit == 1) {
            nextDigit = nextDigit(number);
        }

        while (number >= 0) {

            switch (nextDigit) {
                case 0:
                    zeros++;
                    break;

                case 1:
                    zeroGap = zeros > zeroGap ? zeros : zeroGap;
                    zeros = 0;
                    break;
            }

            nextDigit = nextDigit(number);
        }

        return zeroGap;
    }

    private int nextDigit(int N) {
        if (number <= 0) {
            number = -1;
            return -1;
        }

        int digit = N % 2;
        number /= 2;
        return digit;
    }


}
