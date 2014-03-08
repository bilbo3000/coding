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
        
        return lessThan(root.left, root.val) && greaterThan(root.right, root.val) && isValidBST(root.left) && isValidBST(root.right); 
    }
    
    private boolean lessThan(TreeNode node, int target) {
        if (node == null) {
            return true; 
        }
        
        return node.val < target && lessThan(node.left, target) && lessThan(node.right, target);
    }
    
    private boolean greaterThan(TreeNode node, int target) {
        if (node == null) {
            return true; 
        }
        
        return node.val > target && greaterThan(node.left, target) && greaterThan(node.right, target);
    }
}
