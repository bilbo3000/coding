/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Find the lowest common ancestor of a BST. 
 * Note that the lowest common ancestor of two nodes is the first node whose 
 * value fall in between the two nodes while traversing through the tree. 
 * The solution is to traverse starting from the root, return current node 
 * if it falls between two nodes, otherwise, move to either left or right 
 * chidren, depending on the comparison result. 
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null; 
        }
        
        TreeNode left = p; 
        TreeNode right = q; 
        
        if (p.val > q.val) {
            left = q; 
            right = p; 
        }
        
        TreeNode curr = root; 
        
        while (curr != null) {
            if (curr.val >= left.val && curr.val <= right.val) {
                return curr; 
            } else if (left.val < curr.val && right.val < curr.val) {
                curr = curr.left; 
            } else {
                curr = curr.right; 
            }
        }
        
        return curr; 
    }
}
