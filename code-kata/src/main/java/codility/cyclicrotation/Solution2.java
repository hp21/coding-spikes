package codility.cyclicrotation;

public class Solution2 implements ISolution {

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

        int first = inpArray[0];

        for (int i = 0; i < inpArray.length; i++) {

        }


        return inpArray;
    }


    private void swap(int[] myarray, int element1, int element2) {
        int temp = myarray[element1];
        myarray[element1] = myarray[element2];
        myarray[element2] = temp;
    }

}