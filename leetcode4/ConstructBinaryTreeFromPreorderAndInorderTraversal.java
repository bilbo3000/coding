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
    
    private TreeNode helper(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight){
        if (preLeft > preRight || inLeft > inRight) {
            return null; 
        }
        
        int rootVal = preorder[preLeft]; 
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
        
        node.left = helper(preorder, preLeft + 1, preLeft + leftLen, inorder, inLeft, i - 1); 
        node.right = helper(preorder, preRight - rightLen + 1, preRight, inorder, i + 1, inRight); 
        
        return node; 
    }
}
