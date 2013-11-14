package slist;

import loop.LoopNode;

/**
 * User: hp21 Date: 2013.11.06. Time: 12:32
 */
public interface IListManipulator {
    LoopNode insert(LoopNode node, int value);

    boolean delete(LoopNode node, int value);
}
