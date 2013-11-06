package loop;

/**
 * 
 * See: http://codingfreak.blogspot.com/2012/09/detecting-loop-in-singly-linked-
 * list_22.html
 * 
 * User: hp21 Date: 2013.11.05. Time: 14:51
 */
public class LoopDetector2 implements ILoopDetector {

    public LoopDetector2() {
    }

    @Override
    public boolean hasLoop(LoopNode node) {

        LoopNode hare = node;
        LoopNode turtle = node;

        while (hare != null) {
            turtle = turtle.next();
            hare = hare.next();
            if (hare == null) {
                break;
            }

            hare = hare.next();

            if (turtle == hare) {
                return true;
            }

        }

        return false;
    }

    /**
     * After n == looplengy turtle muves the hare meets the turtle. turtle n,
     * hare 2n steps.
     * 
     * @param node
     * @return
     */
    @Override
    public int looplength(LoopNode node) {
        int count = 0;
        boolean secondRound = false;

        LoopNode hare = node;
        LoopNode turtle = node;

        while (hare != null) {
            turtle = turtle.next();
            count++;

            hare = hare.next();
            if (hare == null) {
                break;
            }

            hare = hare.next();

            if (turtle == hare) {
                if (secondRound) {
                    break;
                }
                secondRound = !secondRound;
                count = 0;
            }

        }

        return hare == null ? -1 : count;
    }
}
