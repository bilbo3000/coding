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
 * This is the top-down approach with O(n^2) worst case scenario. The idea was that for current root, 
 * if it is equal to one the node, it must be the LCA. Otherwise, we need to count the number of
 * matches in ONE of its subtrees. If that subtree contains 0 matches, the LCA must be in the other
 * subtree, so recursively process the other subtree. If that subtree contains 1 match, then the 
 * current root must be the LCA; if that subtree contains both matches, then the LCA must be in 
 * this subtree, recursively process it. 
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root; 
        }
        
        int leftCount = count(root.left, p, q); 
        
        if (leftCount == 1) {
            return root; 
        }
        
        if (leftCount == 0) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }
    
    private int count(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return 0; 
        }
        
        int res = 0; 
        
        if (node == p || node == q) {
            res++; 
        }
        
        res += count(node.left, p, q) + count(node.right, p, q); 
        
        
        return res;
    }
}
