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
        
        return isLessThan(root.left, root.val) && isGreaterThan(root.right, root.val) && isValidBST(root.left) && isValidBST(root.right); 
    }
    
    private boolean isLessThan(TreeNode node, int target) {
        if (node == null) {
            return true; 
        }
        
        return node.val < target && isLessThan(node.left, target) && isLessThan(node.right, target); 
    }
    
    private boolean isGreaterThan(TreeNode node, int target) {
        if (node == null) {
            return true; 
        }
        
        return node.val > target && isGreaterThan(node.left, target) && isGreaterThan(node.right, target);  
    }
}
