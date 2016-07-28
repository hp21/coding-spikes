package visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA. User: hp21 Date: 2013.11.04. Time: 12:35 To
 * change this template use File | Settings | File Templates.
 */
public class NodeVisitor implements IVisitor {

    List<Node> leaves = new LinkedList<Node>();

    public NodeVisitor() {
    }

    @Override
    public void visit(Node node) {

        if (node.isLeaf()) {
            leaves.add(node);
        } else {
            for (Node myNode : node.getChildren()) {
                     myNode.accept(this);
            }
        }
    }

    public String dump() {
        return leaves.toString();
    }
}
