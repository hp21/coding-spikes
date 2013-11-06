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

}
