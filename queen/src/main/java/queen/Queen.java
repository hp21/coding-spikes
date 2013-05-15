package queen;

/**
 *
 */
public class Queen {

    private static final int DEFAULT_SIZE = 8;

    private int size = DEFAULT_SIZE;
    private int[][] chess;

    private int level;

    public Queen() {

        // row,col
        this.chess = new int[size][size];
        level = 0;
    }

    public static void main(String[] args) {
        final Queen queen = new Queen();
        queen.run();
    }

    public void run() {
        solve(level);
    }

    public boolean solve(int level) {

        boolean status = false;

        for (int rowIndex = 0; rowIndex < size; rowIndex++) {
            if (available(rowIndex, level)) {
                chess[rowIndex][level] = 1;

                if (isMoreColumnToPlace(level)) {

                    status = solve(level + 1);
                    if (!status) {
                        chess[rowIndex][level] = 0;
                        continue;
                    }
                } /*else {
                    // last column
                    status = true;
                }*/

                // no more column

                if (isLastColumn(level)) {
                    printChess();
                    status = true;
                    break;
                }

                if (outmostLevel(level, status)) {
                    break; // find next solution
                }

            }
        }

        return status;
    }

    private boolean outmostLevel(int level, boolean status) {
        return status && level != 0;
    }

    private boolean isLastColumn(int level) {
        return level == size - 1;
    }

    private boolean isMoreColumnToPlace(int level) {
        return level < size - 1;
    }

    public boolean available(int rowIndex, int colIndex) {

        if (!checkRowsFree(rowIndex, colIndex))
            return false;

        return checkDiagonalOK(rowIndex, colIndex);
    }

    public boolean checkDiagonalOK(int rowIndex, int colIndex) {
        for (int col = colIndex, row = rowIndex; col >= 0 && row >= 0; col--, row--) {
            if (chess[row][col] > 0) {
                return false;
            }
        }

        for (int col = colIndex, row = rowIndex; col >= 0 && col < 8 && row >= 0 && row < 8; col--, row++) {
            if (chess[row][col] > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean checkRowsFree(int rowIndex, int colIndex) {
        for (int myCol = 0; myCol <= colIndex; myCol++) {

            if (chess[rowIndex][myCol] > 0) {
                return false;

            }
        }

        return true;
    }

    private void printChess() {

        for (int row = 0; row < size; row++) {

            for (int column = 0; column < size; column++) {
                System.out.print(chess[row][column] + " ");
            }

            System.out.println("");
        }

        System.out.println("\n=======================\n");
    }

    private void initChess() {
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                chess[row][column] = 0;
            }
        }
    }

    public int[][] getChess() {
        return chess;
    }
}
