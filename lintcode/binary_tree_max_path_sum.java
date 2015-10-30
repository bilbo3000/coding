/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * 
 * O(n) time, because it visits each node once. 
 */
public class Solution {
    private int global = Integer.MIN_VALUE; 
    
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        helper(root);
        
        return global; 
    }
    
    private int helper(TreeNode node) {
        if (node == null) {
            return 0; 
        }
        
        int max = node.val;
        int left = helper(node.left); 
        int right = helper(node.right);
        max = Math.max(max, left + node.val);
        max = Math.max(max, right + node.val); 
        global = Math.max(global, max);
        global = Math.max(global, left + node.val + right);
        
        return max; 
    }
}
