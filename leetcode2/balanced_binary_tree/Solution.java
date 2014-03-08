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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true; 
        int diff = Math.abs(height(root.left) - height(root.right)); 
        
        if (diff > 1) return false; 
        
        return isBalanced(root.left) && isBalanced(root.right); 
    }
    
    int height(TreeNode node) {
        if (node == null) return 0; 
        return Math.max(height(node.left), height(node.right)) + 1; 
    }
}
