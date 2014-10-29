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
        
        if (node.left == null && node.right == null) {
            max = Math.max(max, node.val); 
            return node.val; 
        }
        
        int maxx = Integer.MIN_VALUE; 
        
        int left = 0; 
        int right = 0; 
        
        if (node.left != null) {
            left = helper(node.left);
            maxx = Math.max(maxx, left); 
        }
        
        if (node.right != null) {
            right = helper(node.right); 
            maxx = Math.max(maxx, right); 
        }
        max = Math.max(max, maxx); 
        int temp = maxx + node.val; 
        maxx = Math.max(node.val, temp); 
        max = Math.max(max, maxx); 
        max = Math.max(max, left + right + node.val); 
        
        return maxx; 
    }
}
