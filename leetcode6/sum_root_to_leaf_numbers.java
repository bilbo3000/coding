/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Find the sum of the root-to-leaf numbers. 
 * The idea was DFS traverse the tree. For each node, times the value by 10 and 
 * add the value of this node to it. If the current node is a leaf node, accumulate
 * the result, otherwise, recursively move on to not empty child and pass in the 
 * value.
 */
public class Solution {
    private int sum = 0; 
    
    public int sumNumbers(TreeNode root) {
        helper(root, 0); 
        
        return sum; 
    }
    
    private void helper(TreeNode node, int val) {
        if (node == null) {
            return; 
        }
        
        val = val * 10 + node.val; 
        
        if (node.left == null && node.right == null) {
            // A leaf node
            sum += val; 
            return; 
        }
        
        if (node.left != null) {
            helper(node.left, val); 
        }
        
        if (node.right != null) {
            helper(node.right, val); 
        }
    }
}
