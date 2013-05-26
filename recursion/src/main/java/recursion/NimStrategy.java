package recursion;

/**
 * Date: 2013.05.26. Time: 14:43
 */
public class NimStrategy {

    public static final int NO_GOOD_MOVE = -1;
    private static final int MAX_MOVE = 3;

    private int maxMove = MAX_MOVE;
    private boolean found;

    public NimStrategy() {
    }

    public NimStrategy(int maxMove) {
        this.maxMove = maxMove;
    }

    /*
     * public boolean findGoodMove(int coins) { return findGoodMove(coins,
     * maxMove); }
     */

    public int findGoodMove(int coins) {

        for (int taken = 1; taken <= maxMove; taken++) {
            final boolean badPosition = isBadPosition(coins - taken);

            if (badPosition) {
                return taken;
            }

        }

        return NO_GOOD_MOVE;
    }

    private boolean isBadPosition(int coins) {

        if (coins == 1) {
            return true;
        }

        final int goodMove = findGoodMove(coins);
        final boolean result = goodMove == NO_GOOD_MOVE;
        return result;

    }

    public void setMaxMove(int maxMove) {
        this.maxMove = maxMove;
    }
}
