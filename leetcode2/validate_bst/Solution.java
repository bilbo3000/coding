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
    public boolean lessHelper(TreeNode root, int val) {
        if (root == null) return true; 
        
        return root.val < val && lessHelper(root.left, val) && lessHelper(root.right, val);  
    }
    
    public boolean greatHelper(TreeNode root, int val) {
        if (root == null) return true; 
        
        return root.val > val && greatHelper(root.left, val) && greatHelper(root.right, val);  
    }
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true; 
        
        return lessHelper(root.left, root.val) && greatHelper(root.right, root.val) && isValidBST(root.left) && isValidBST(root.right); 
    }
}
