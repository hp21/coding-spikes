package q13;

import java.util.Arrays;
import java.util.List;

import ibook.common.LoopNode;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by hp21 on 2014.02.09..
 */
public class ReverseListPrinterTest1 {

    private ReverseListPrinter1 reverseListPrinter;

    @Before
    public void setUp() throws Exception {
        reverseListPrinter = new ReverseListPrinter1();

    }

    /**
     * Reverse print should be 1,2,3,4,5,6,7 as the original list is ordered as
     * 7,6,5,4,3,2,1
     * 
     * @throws Exception
     */
    @Test
    public void testPrintReverse() throws Exception {

        LoopNode node7 = new LoopNode(7);
        LoopNode node6 = new LoopNode(6);
        LoopNode node5 = new LoopNode(5);
        LoopNode node4 = new LoopNode(4);
        LoopNode node3 = new LoopNode(3);
        LoopNode node2 = new LoopNode(2);
        LoopNode node1 = new LoopNode(1);

        node7.setNext(node6);
        node6.setNext(node5);
        node5.setNext(node4);
        node4.setNext(node3);
        node3.setNext(node2);
        node2.setNext(node1);

        reverseListPrinter.printReverse(node7);
    }

}
