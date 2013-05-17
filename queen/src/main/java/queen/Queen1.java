package queen;

/**
 *
 */
public class Queen1 {

    private static final int DEFAULT_SIZE = 8;

    private int size = DEFAULT_SIZE;
    private int[][] chess;

    private int level;

    public Queen1() {

        // row,col
        this.chess = new int[size][size];
        level = 0;
    }

    public static void main(String[] args) {
        final Queen1 queen = new Queen1();
        queen.run();
    }

    public void run() {
        solve(level);
    }

    public boolean solve(int column) {

        boolean status = false;

        for (int rowIndex = 0; rowIndex < size; rowIndex++) {
            if (available(rowIndex, column)) {
                chess[rowIndex][column] = 1;

                if (isMoreColumnToPlace(column)) {

                    status = solve(column + 1);
                    if (!status) {
                        chess[rowIndex][column] = 0;
                        continue;
                    }
                }

                if (isLastColumn(column)) {
                    printChess();
                    initChess();
                    status = true;
                    break;
                }

                if (lowLevelSolutionFound(column, status)) {
                    break; // find next solution
                }
            }
        }

        return status;
    }

    private boolean lowLevelSolutionFound(int level, boolean status) {
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
