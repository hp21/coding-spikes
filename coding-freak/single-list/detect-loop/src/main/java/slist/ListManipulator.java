package slist;

import loop.LoopNode;

/**
 * User: hp21 Date: 2013.11.06. Time: 12:27
 */
public class ListManipulator implements IListManipulator {

    @Override
    public LoopNode insert(LoopNode node, int value) {

        LoopNode myNode = node;
        LoopNode prevNode = node;

        while (myNode != null && value <= myNode.getValue()) {
            prevNode = myNode;
            myNode = myNode.next();
        }

        if (myNode == null && prevNode == null) {
            return new LoopNode(value);
        } else if (myNode == null && prevNode != null) {
            final LoopNode retNode = new LoopNode(value);
            prevNode.setNext(retNode);
            retNode.setNext(myNode);
            return retNode;
        }

        final LoopNode retNode = new LoopNode(value);
        prevNode.setNext(retNode);
        retNode.setNext(myNode);
        return retNode;

    }

    @Override
    public boolean delete(LoopNode node, int value) {

        return true;
    }

}
