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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1); 
    }
    
    private TreeNode helper(int[] inorder, int a, int b, int[] postorder, int c, int d) {
        if (a > b || c > d) {
            return null; 
        }
        
        TreeNode root = new TreeNode(postorder[d]); 
        int i = a; 
        
        while (i <= b) {
            if (inorder[i] == postorder[d]) break; 
            i++; 
        }
        
        root.left = helper(inorder, a, i - 1, postorder, c, c + (i - a) - 1); 
        root.right = helper(inorder, i + 1, b, postorder, d - (b - i), d - 1); 
        
        return root; 
    }
}
