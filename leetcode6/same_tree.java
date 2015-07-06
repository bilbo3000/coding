/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Check whether two given binary trees are the same. 
 * Recursive solution. At each level of recursion, it compares whether given two nodes are 
 * the same. If so, the current level would return the AND of the results of its two children.
 * By doing so, the result would propagate all the way to the root as the final result. 
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true; 
        }
        
        if (p == null || q == null) {
            return false; 
        }
        
        if (p.val != q.val) {
            return false; 
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 
    }
}
