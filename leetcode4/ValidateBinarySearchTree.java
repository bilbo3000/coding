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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true; 
        }
        
        return allLess(root.left, root.val) && allGreater(root.right, root.val) && isValidBST(root.left) && isValidBST(root.right); 
    }
    
    public boolean allGreater(TreeNode node, int target) {
        if (node == null) {
            return true; 
        }
        
        if (node.val <= target) {
            return false; 
        }
        
        return allGreater(node.left, target) && allGreater(node.right, target); 
    }
    
    public boolean allLess(TreeNode node, int target) {
        if (node == null) {
            return true; 
        }
        
        if (node.val >= target) {
            return false; 
        }
        
        return allLess(node.left, target) && allLess(node.right, target); 
    }
}
