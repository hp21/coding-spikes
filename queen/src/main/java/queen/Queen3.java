package queen;

/**
 *
 */
public class Queen3 {

    private static final int DEFAULT_SIZE = 8;

    private int size = DEFAULT_SIZE;
    private int[][] chess;

    private int level;

    private int numberOfSolutions;

    public Queen3() {

        // row,col
        this.chess = new int[size][size];
        level = 0;
    }

    public static void main(String[] args) {
        final Queen3 queen = new Queen3();
        queen.run();
    }

    public void run() {
        solve(level);
    }

    public void solve(int columnIndex) {

        for (int rowIndex = 0; rowIndex < size; rowIndex++) {
            if (available(rowIndex, columnIndex)) {
                chess[rowIndex][columnIndex] = 1;

                if (isMoreColumnToPlace(columnIndex)) {
                    solve(columnIndex + 1);
                } else {
                    numberOfSolutions++;
                    printChess();
                }

                chess[rowIndex][columnIndex] = 0;
            }
        }

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

        System.out.println("\n========= Solution was: " + numberOfSolutions + "==============\n");
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
