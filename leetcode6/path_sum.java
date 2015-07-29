/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Check whether a binary tree has a root-to-leaf path sum that is equal 
 * to the given target. 
 * Solve it recursively. The idea was to compare the remaining sum with 
 * the value of current node. If current node is a leaf and its value is 
 * equal to the remaining sum, then we found a path. Otherwise, recursively
 * move onto left and right child with remaining target value. 
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false; 
        }
        
        if (root.left == null && root.right == null && root.val == sum) {
            return true; 
        }
        
        boolean result = hasPathSum(root.left, sum - root.val); 
        
        if (result) {
            return true; 
        }
        
        return hasPathSum(root.right, sum - root.val); 
    }
}
