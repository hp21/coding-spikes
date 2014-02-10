package q13;

import java.util.List;
import java.util.Stack;

/**
 * Created by U292148 on 2014.02.09..
 */
public class ReverseListPrinter {

    public void printReverse(List<?> list) {

        final Stack<Object> stack = new Stack<Object>();

        if (list == null) {
            return;
        }

        for (Object item : list) {
            stack.push(item);
        }

        Object item;

        while (!stack.empty()) {
            item = stack.pop();
            System.out.print(item + ", ");
        }

        System.out.println();

    }

}
