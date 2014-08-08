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
    
    public TreeNode helper(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null; 
        }
        
        int rootVal = postorder[postRight]; 
        TreeNode node = new TreeNode(rootVal);
        
        int i = inLeft; 
        
        while (i <= inRight) {
            if (inorder[i] == rootVal) {
                break; 
            }
            
            i++; 
        }
        
        int leftLen = i - inLeft; 
        int rightLen = inRight - i; 
        
        node.left = helper(inorder, inLeft, i - 1, postorder, postLeft, postLeft + leftLen - 1);
        node.right = helper(inorder, i + 1, inRight, postorder, postRight - rightLen, postRight - 1); 
        
        return node; 
    }
}
