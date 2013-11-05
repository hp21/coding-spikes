package visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * User: hp21 Date: 2013.11.02. Time: 15:22
 */
public class Node {

    private int value;

    private List<Node> children = new LinkedList<Node>();

    public Node(int value, List<Node> children) {
        this.value = value;
        this.children = children == null ? this.children : children;
    }

    public int getValue() {
        return value;
    }

    public List<Node> getChildren() {
        return children;
    }

    public boolean addNode(Node node) {
        return children.add(node);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + ", children=" + children + '}';
    }
}
