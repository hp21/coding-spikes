package pda;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

/**
 * Created User: Peter Horvath/ Date: 2013.07.09. Time: 12:46
 */
public class PDAStack extends ArrayDeque<Character> implements Deque<Character> {

    public static String EMPTY_STACK = "\0000";

    public PDAStack(Collection<? extends Character> c) {
        super(c);
    }

    public PDAStack(Character... states) {
        for (Character state : states) {
            push(state);
        }
    }
}
