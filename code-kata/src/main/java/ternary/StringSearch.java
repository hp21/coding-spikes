package ternary;

import tst.TernaryNode;

/**
 * Created by hp21 on 2014.11.11..
 */
public class StringSearch {

    public TernaryNode findString(TernaryNode node, String str, int index) {

        if (node == null) {
            return null;
        }

        final char myChar = str.charAt(index);

        if (Character.compare(myChar, node.getaChar()) == -1) {
            return findString(node.getLow(), str, index + 1);
        } else if (Character.compare(myChar, node.getaChar()) == 1) {
            return findString(node.getHigh(), str, index + 1);
        } else {
            return findString(node.getMid(), str, index + 1);
        }

    }

}
