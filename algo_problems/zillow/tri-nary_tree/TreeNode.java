/**
 * Represent a node in the tri-nary tree.
 * The assumption made here is that the value store
 * at each node is type int.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode middle;
    TreeNode right;
    TreeNode parent;

    TreeNode(int x) {
        this.val = x;
    }
}
