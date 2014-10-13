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
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1); 
    }
    
    private TreeNode helper(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (l1 > r1 || l2 > r2) {
            return null; 
        }
        
        TreeNode root = new TreeNode(preorder[l1]);
        
        int i = l2; 
        
        while (i <= r2) {
            if (inorder[i] == preorder[l1]) {
                break; 
            }
            
            i++; 
        }
        
        int len1 = i - l2; 
        int len2 = r2 - i; 
        
        root.left = helper(preorder, l1 + 1, l1 + len1, inorder, l2, i - 1); 
        root.right = helper(preorder, r1 - len2 + 1, r1, inorder, i + 1, r2); 
        
        return root; 
    }
}
