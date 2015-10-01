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
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     * 
     * The first node that has one node in its left subtree and the other node 
     * in the other subtree would be the LCA. 
     * 
     * O(n^2)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == A || root == B) {
            return root; 
        }
        
        boolean left = contains(root.left, A, B);
        boolean right = contains(root.right, A, B);
        
        if (left && right) {
            return root; 
        }
        
        if (!left && right) {
            return lowestCommonAncestor(root.right, A, B);
        } else {
            return lowestCommonAncestor(root.left, A, B);
        }
    }
    
    private boolean contains(TreeNode node, TreeNode A, TreeNode B) {
        if (node == null) {
            return false; 
        }
        
        if (node == A || node == B) {
            return true; 
        }
        else {
            return contains(node.left, A, B) || contains(node.right, A, B);
        }
    }
}
