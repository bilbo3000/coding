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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1); 
    }
    
    public TreeNode helper(int[] inorder, int a, int b, int[] preorder, int c, int d) {
        if (a > b || c > d) {
            return null; 
        }
        
        TreeNode root = new TreeNode(preorder[c]); 
        int i = a; 
        
        while (i <= b) {
            if (inorder[i] == preorder[c]) break; 
            
            i++; 
        }
        
        root.left = helper(inorder, a, i - 1, preorder, c + 1, c + (i - a)); 
        root.right = helper(inorder, i + 1, b, preorder, d - (b - i) + 1, d); 
        
        return root; 
    }
}
