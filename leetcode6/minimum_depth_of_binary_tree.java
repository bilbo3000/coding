/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Find the minimum depth of a binary tree. 
 * Recursive solution. Passing the current height along the recursive call.
 * When it reaches a leaf, compare the height min height and update it 
 * accordingly. 
 */
public class Solution {
    private int result = Integer.MAX_VALUE; 
    
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0; 
        }
        
        helper(root, 1);
        
        return result; 
    }
    
    private void helper(TreeNode node, int level) {
        if (node == null) {
            return; 
        }
        
        if (node.left == null && node.right == null) {
            result = Math.min(result, level);
            return; 
        }
        
        if (node.left != null) {
            helper(node.left, level + 1); 
        }
        
        if (node.right != null) {
            helper(node.right, level + 1); 
        }
    }
}
