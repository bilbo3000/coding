/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int result = helper(root);
        return Math.max(max, result);
    }

    public int helper(TreeNode node) {
        if (node == null) return 0;

        int left = helper(node.left);
        int right = helper(node.right);
        max = Math.max(max, left + node.val + right);

        int maxx = Math.max(left + node.val, right + node.val);
        maxx = Math.max(maxx, node.val);
        max = Math.max(maxx, max); 

        return maxx;
    }
}
