package codility.cyclicrotation;

public class Solution implements ISolution {

    @Override
    public int[] solution(int[] A, int K) {
        return solution1(A, K);
    }

    private int[] solution1(int[] inpArray, int numOfRotations) {

        if (inpArray == null || inpArray.length == 0) {
            return inpArray;
        }

        if (numOfRotations % inpArray.length == 0) {
            return inpArray;
        }

        int shift = numOfRotations > inpArray.length ? numOfRotations % inpArray.length : numOfRotations;
        int passes = gcd(inpArray.length, shift);

        for (int i = 0; i < passes; i++) {

            int temp = -1;
            int start = i;

            for (int internal = i; ; internal = internal + shift) {
                int next = (internal + shift) % inpArray.length;

                int temp1 = inpArray[next];
                temp = start == internal ? inpArray[internal] : temp;
                inpArray[next] = temp;
                temp = temp1;

                if (next == start) {
                    break;
                }
            }
        }


        return inpArray;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }
}