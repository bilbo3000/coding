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
        helper(root);
        
        return max; 
    }
    
    private int helper(TreeNode node) {
        if (node == null) {
            return 0; 
        }
        
        int leftMax = helper(node.left);
        int rightMax = helper(node.right); 
        int maxx = Math.max(leftMax, rightMax); 
        maxx = Math.max(node.val, maxx + node.val); 
        max = Math.max(max, maxx); 
        max = Math.max(max, leftMax + node.val + rightMax); 
        
        return maxx; 
    }
}
