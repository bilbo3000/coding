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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0; 
        }
        
        return helper(root, 0); 
    }
    
    public int helper(TreeNode node, int sum) {
        if (node == null) {
            return 0; 
        }
        
        if (node.left == null && node.right == null) {
            return sum * 10 + node.val; 
        }
        
        if (node.left == null) {
            return helper(node.right, sum * 10 + node.val); 
        }
        
        if (node.right == null) {
            return helper(node.left, sum * 10 + node.val); 
        }
        
        return helper(node.left, sum * 10 + node.val) + helper(node.right, sum * 10 + node.val); 
    }
}
