/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     * 
     * Not efficient. 
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true; 
        }
        
        boolean result = isLessThan(root.left, root.val);
        
        if (result) {
            result = isGreaterThan(root.right, root.val);
        } 
        
        if (result) {
            result = isValidBST(root.left);
        }
        
        if (result) {
            result = isValidBST(root.right);
        }
        
        return result; 
    }
    
    private boolean isLessThan(TreeNode node, int val) {
        if (node == null) {
            return true; 
        }
        
        if (node.val >= val) {
            return false; 
        }
        
        return isLessThan(node.left, val) && isLessThan(node.right, val);
    }
    
    private boolean isGreaterThan(TreeNode node, int val) {
        if (node == null) {
            return true; 
        }
        
        if (node.val <= val) {
            return false; 
        }
        
        return isGreaterThan(node.left, val) && isGreaterThan(node.right, val);
    }
}
