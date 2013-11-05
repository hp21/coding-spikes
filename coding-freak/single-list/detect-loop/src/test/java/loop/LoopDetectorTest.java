package loop;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * User: hp21 Date: 2013.11.05. Time: 14:52
 */
public class LoopDetectorTest {

    private LoopDetector detector;
    private LoopNode node1;
    private LoopNode node2;
    private LoopNode node3;
    private LoopNode node4;
    private LoopNode node5;

    @Before
    public void setUp() {
        this.detector = new LoopDetector();

        node1 = new LoopNode(1);
        node2 = new LoopNode(2);
        node3 = new LoopNode(3);
        node4 = new LoopNode(4);
        node5 = new LoopNode(5);
    }

    @Test
    public void testNullNode() {
        final boolean actual = detector.hasLoop(null);

        assertThat(actual, equalTo(false));
    }

    @Test
    public void test1() {
        final LoopNode loopNode = new LoopNode(1);
        final boolean actual = detector.hasLoop(loopNode);

        assertThat(actual, equalTo(false));
    }

    @Test
    public void test2NooLoop() {
        node1.setNext(node2);
        final boolean actual = detector.hasLoop(node1);

        assertThat(actual, equalTo(false));
    }

    @Test
    public void test4NooLoop() {
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        final boolean actual = detector.hasLoop(node1);

        assertThat(actual, equalTo(false));
    }

    @Test
    public void test42WithLoop() {
        // 1-2-1-2-1-2-1-2...

        node1.setNext(node2);
        node2.setNext(node1);

        final boolean actual = detector.hasLoop(node1);

        assertThat(actual, equalTo(true));
    }

    @Test
    public void test4WithLoop() {
        // 1-2-3-4-5 -3-4-5 -3-4-5..........

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node3);

        final boolean actual = detector.hasLoop(node1);

        assertThat(actual, equalTo(true));
    }
}
