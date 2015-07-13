/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Invert a binary tree. 
 * Recursive solution. For the current node, invert left and right subtree 
 * recursively first. Then swap the left and right subtree of the current 
 * node before return. 
 * The key of this problem is to invert subtrees first before invert current 
 * node. 
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root; 
        }
        
        invertTree(root.left);
        invertTree(root.right); 
        
        TreeNode temp = root.left; 
        root.left = root.right; 
        root.right = temp; 
        
        return root; 
    }
}
