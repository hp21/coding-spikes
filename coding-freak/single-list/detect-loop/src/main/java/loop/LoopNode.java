package loop;

/**
 * User: hp2 Date: 2013.11.05. Time: 14:48
 */
public class LoopNode {

    private int value;
    private LoopNode next;

    public LoopNode(int value) {
        this(value, null);
    }

    public LoopNode(int value, LoopNode next) {
        this.value = value;
        this.next = next;
    }

    public LoopNode next() {
        return next;
    }

    public void setNext(LoopNode next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "LoopNode{" + "value=" + value + '}';
    }
}
