/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Convert a binary search tree from an inorder and a preorder traversal. 
 * Solve it recursively. The idea was to use the first element in the preorder
 * segment as root, then find that element in the inorder. Then split inorder 
 * at that element and recursively process left and right segment. 
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1); 
    }
    
    private TreeNode helper(int[] preorder, int a, int b, int[] inorder, int c, int d) {
        if (a > b || c > d) {
            return null; 
        }
        
        if (a == b || c == d) {
            return new TreeNode(preorder[a]);
        }
        
        int root = preorder[a]; 
        int i = c; 
        
        while (i <= d && inorder[i] != root) {
            i++; 
        }
        
        int leftLen = i - c; 
        int rightLen = d - i; 
        
        TreeNode node = new TreeNode(root);
        node.left = helper(preorder, a + 1, b - rightLen, inorder, c, i - 1); 
        node.right = helper(preorder, b - rightLen + 1, b, inorder, i + 1, d);
        
        return node; 
    }
}
