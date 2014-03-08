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
    private int sum = 0; 
    
    public int sumNumbers(TreeNode root) {
        helper(root, 0); 
        
        return sum; 
    }
    
    private void helper(TreeNode node, int n) {
        if (node == null) {
            return; 
        }
        
        if (node.left == null && node.right == null) {
            n = n * 10 + node.val; 
            sum += n; 
            return; 
        }
        
        helper(node.left, n * 10 + node.val); 
        helper(node.right, n * 10 + node.val); 
    }
}
