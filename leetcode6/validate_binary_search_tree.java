/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Validate if a given binary tree is valid. 
 * Solve it recursively. The idea was for each node, we not only need to 
 * verify that left node is less than and the right node is larger than the
 * root, we also need to verify that all nodes in its left subtree are less 
 * than and all nodes in its right subtree are greater than the root. 
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true; 
        }
        
        if (root.left != null && root.left.val >= root.val) {
            return false; 
        }
        
        if (root.right != null && root.right.val <= root.val) {
            return false; 
        }
        
        boolean result = validateLeftChild(root.left, root.val); 
        
        if (result) {
            result = validateRightChild(root.right, root.val); 
        }
        
        if (result) {
            result = isValidBST(root.left);
        }
        
        if (result) {
            result = isValidBST(root.right);
        }
        
        return result; 
    }
    
    private boolean validateLeftChild(TreeNode node, int val) {
        if (node == null) {
            return true; 
        }
        
        if (node.val >= val) {
            return false; 
        }
        
        boolean result = validateLeftChild(node.left, val);
        
        if (result) {
            result = validateLeftChild(node.right, val);
        }
        
        return result; 
    }
    
    private boolean validateRightChild(TreeNode node, int val) {
        if (node == null) {
            return true; 
        }
        
        if (node.val <= val) {
            return false; 
        }
        
        boolean result = validateRightChild(node.left, val); 
        
        if (result) {
            result = validateRightChild(node.right, val); 
        }
        
        return result; 
    }
}
