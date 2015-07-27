/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Check if given binary tree is symetric. 
 * The recursive solution. Traverse left and right subtrees via inorder 
 * traverse using one recursive function. Each time checks current two 
 * nodes. If passes, continue on first tree and the second tree in 
 * mirror order. 
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true; 
        }
        
        return check(root.left, root.right); 
    }
    
    private boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true; 
        }
        
        if (node1 == null && node2 != null || node1 != null && node2 == null) {
            return false; 
        }
        
        if (node1.val != node2.val) {
            return false; 
        }
        
        return check(node1.left, node2.right) && check(node1.right, node2.left); 
    }
}
