package group3;

/**
 * Created by U292148 on 2015.07.17..
 */
public class Create3ElementGroups {

    private final int numberOfElements;
    private final int[][] square;

    public Create3ElementGroups(int i) {
        numberOfElements = i;

        square = new int[numberOfElements][numberOfElements];
    }

    public static void main(String[] args) {
        Create3ElementGroups create3ElementGroups = new Create3ElementGroups(3);
        create3ElementGroups.run();

    }

    public void run() {

        //        for (int row = 0; row < numberOfElements; row++) {
        //            boolean ok=placeRow(row);
        //            if (ok) {
        //                System.out.println("\n======================");
        //                System.out.println(square );
        //            }
        //        }

        placeRows();

    }

    private void placeRows() {
        placeRows(0);
    }


    private void placeRows(int i) {
        for (int row = i; row < numberOfElements; row++) {
            for (int z = 0; z < numberOfElements; z++) {

                boolean ok = placeRow(row, z);
                if (ok && i == numberOfElements - 1) {
                    System.out.println("\n======================");
                    System.out.println(square);
                }

            }
        }
    }


    private boolean placeRow(int i, int row) {
        for (int col = 0; col < numberOfElements; col++) {

            //            square[row][col];
        }


        return true;//TODO: Fixme
    }
}
