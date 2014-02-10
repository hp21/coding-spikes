package q13;

import java.util.List;
import java.util.Stack;

import ibook.common.LoopNode;

/**
 * Created by U292148 on 2014.02.09..
 */
public class ReverseListPrinter1 {

    public void printReverse(LoopNode node) {

        if (node == null) {
            return;
        }

        printReverse(node.next());

        System.out.print(node.getValue() + ", ");
    }

}
