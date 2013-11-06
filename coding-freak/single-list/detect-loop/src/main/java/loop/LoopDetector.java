package loop;

/**
 * 
 * See: http://codingfreak.blogspot.com/2012/09/detecting-loop-in-singly-linked-
 * list_22.html
 * 
 * User: hp21 Date: 2013.11.05. Time: 14:51
 */
public class LoopDetector implements ILoopDetector {

    public LoopDetector() {
    }

    @Override
    public boolean hasLoop(LoopNode node) {
        if (node == null) {
            return false;
        }

        LoopNode hare = node.next();
        LoopNode turtle = node.next();

        while (hare != null) {
            hare = hare.next();
            if (hare == null) {
                break;
            }

            if (hare == turtle) {
                return true;
            }

            turtle = turtle.next();
            hare = hare.next();
        }

        return false;
    }

    public boolean hasLoop2(LoopNode node) {

        LoopNode hare = node;
        LoopNode turtle = node;

        while (hare != null) {
            turtle = turtle.next();
            hare = hare.next();
            if (hare == null) {
                break;
            }

            hare = hare.next();

            if (hare == turtle) {
                return true;
            }

        }

        return false;
    }
}
