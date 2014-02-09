package q13;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by hp21 on 2014.02.09..
 */
public class ReverseListPrinterTest {

    private ReverseListPrinter reverseListPrinter;

    @Before
    public void setUp() throws Exception {
        reverseListPrinter = new ReverseListPrinter();

    }

    @Test
    public void testPrintReverse() throws Exception {
        final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        reverseListPrinter.printReverse(list);
    }
}
