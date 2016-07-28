package loop;

/**
 * Created with IntelliJ IDEA. User: hp21 Date: 2013.11.06. Time: 9:14 To
 * change this template use File | Settings | File Templates.
 */
public interface ILoopDetector {
    boolean hasLoop(LoopNode node);

    int looplength(LoopNode node);
}
