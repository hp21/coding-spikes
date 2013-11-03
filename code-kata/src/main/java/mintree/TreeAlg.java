package mintree;

/**
 * User: hp21 Date: 2013.11.02. Time: 15:25
 */
public class TreeAlg {

    public TreeAlg() {
    }

    public Integer mintree(TreeNode node) {

        if (node.isLeaf()) {
            return oddValue(node);
        }

        Integer min = oddValue(node);

        for (TreeNode myNode : node.getChildren()) {
            final Integer nodeMin = mintree(myNode);

            if (nodeMin != null) {
                min = min == null ? nodeMin : (min > nodeMin ? nodeMin : min);
            }
        }

        return min;
    }

    private Integer oddValue(TreeNode node) {
        return isOdd(node.getValue()) ? node.getValue() : null;
    }

    private boolean isOdd(int number) {
        final int remainder = number % 2;
        return remainder == 1 || remainder == -1;
    }

}
