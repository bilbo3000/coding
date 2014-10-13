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
    
    private TreeNode helper(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2) {
        if (l1 > r1 || l2 > r2) {
            return null; 
        }
        
        TreeNode root = new TreeNode(postorder[r2]);
        
        int i = l1; 
        
        while (i < r1) {
            if (inorder[i] == postorder[r2]) {
                break; 
            }
            
            i++; 
        }
        
        int len1 = i - l1; 
        int len2 = r1 - i; 
        
        root.left = helper(inorder, l1, i - 1, postorder, l2, l2 + len1 - 1); 
        root.right = helper(inorder, i + 1, r1, postorder, r2 - len2, r2 - 1); 
        
        return root; 
    }
}
