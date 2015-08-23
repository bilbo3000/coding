/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Find the lowest common ancestor of a binary tree (Not BST).
 * Bottom up approach with worst case O(n). The idea was that each recursive call needs to find 
 * either the LCA or one of the target, or null. If current root is one of the target, return 
 * that root. If current root is null, also return. Otherwise, recursively process left subtree
 * or right subtree. If the results from both subtrees are not null, then the current node must 
 * be LCA, return. If both are null, return null, meaning not able to find LCA or either target. 
 * Otherwise, return the non-null node (could be either LCA or one of the target). 
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null; 
        }
        
        if (root == p || root == q) {
            return root; 
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) {
            return root; 
        }
        
        if (left == null) {
            return right; 
        } else {
            return left; 
        }
    }
    
}
