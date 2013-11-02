package mintree;

import java.util.LinkedList;
import java.util.List;

/**
 * User: hp21 Date: 2013.11.02. Time: 15:22
 */
public class TreeNode {

    private int value;

    private List<TreeNode> children = new LinkedList<TreeNode>();

    public TreeNode(int value, List<TreeNode> children) {
        this.value = value;
        this.children = children == null ? this.children : children;
    }

    public int getValue() {
        return value;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public boolean addNode(TreeNode node) {
        return children.add(node);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    @Override
    public String toString() {
        return "TreeNode{" + "value=" + value + ", children=" + children + '}';
    }
}
