package ls58;

/**
 * Created by hp21 on 2014.02.16..
 */
public class NumPermutation {

    /**
     * permutes number 0..9 with numberOfDigits length.
     * 
     * @param numberOfDigits
     */
    public void permute(int numberOfDigits) {

        if (numberOfDigits <= 0) {
            return;
        }

        int[] numbers = new int[numberOfDigits];
        permute(numbers, --numberOfDigits);

    }

    private void permute(int[] numbers, int numberOfDigits) {

        if (numberOfDigits < 0) {
            printArray(numbers);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            numbers[numberOfDigits] = i;
            permute(numbers, numberOfDigits - 1);
        }

    }

    private void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d", numbers[i]);
        }

        System.out.println();
    }
}
