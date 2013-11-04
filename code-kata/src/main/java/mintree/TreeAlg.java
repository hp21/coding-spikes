package mintree;

/**
 * Find the lowest odd number in an arbitrary tree User: hp21 Date: 2013.11.02.
 * Time: 15:25
 */
public class TreeAlg {

    public TreeAlg() {
    }

    public Integer mintree(TreeNode node) {

        if (node.isLeaf()) {
            return nodeValue(node);
        }

        Integer min = nodeValue(node);

        for (TreeNode myNode : node.getChildren()) {
            final Integer nodeMin = mintree(myNode);

            if (nodeMin != null) {
                min = min == null ? nodeMin : (min > nodeMin ? nodeMin : min);
            }
        }

        return min;
    }

    private Integer nodeValue(TreeNode node) {
        final Integer value = node.getValue();
        return oddValue(value);
    }

    private Integer oddValue(Integer value) {
        return isOdd(value) ? value : null;
    }

    private boolean isOdd(int number) {
        final int remainder = number % 2;
        return remainder == 1 || remainder == -1;
    }

}
