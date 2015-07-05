/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Find the maximum depth of a binary tree. 
 * Solve it with recursive solution. For each given node, its depth is the 
 * max depth of its two children (0 if null) plus 1. Each level of recursion 
 * calculates and returns the depth from the current node. 
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0; 
        }
        
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1; 
    }
}
