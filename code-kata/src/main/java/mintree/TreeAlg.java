package mintree;

/**
 * User: hp21 Date: 2013.11.02. Time: 15:25 To change this template use File |
 * Settings | File Templates.
 */
public class TreeAlg {

    public TreeAlg() {
    }

    public int mintree(TreeNode node) {

        if (node.isLeaf()) {
            return node.getValue();
        }

        int min = node.getValue();

        for (TreeNode myNode : node.getChildren()) {
            final int nodeMin = mintree(myNode);
            min = min > nodeMin ? nodeMin : min;
        }

        return min;
    }

    /**
     * Use generic finction for comparision
     * 
     * @param node
     * @param operation
     * @return
     */
    public int doTree(TreeNode node, IOperation<Integer, Integer> operation) {

        if (node.isLeaf()) {
            return node.getValue();
        }

        int min = node.getValue();

        for (TreeNode myNode : node.getChildren()) {
            final int nodeMin = doTree(myNode, operation);
            min = operation.operation(min, nodeMin);
        }

        return min;
    }

}
