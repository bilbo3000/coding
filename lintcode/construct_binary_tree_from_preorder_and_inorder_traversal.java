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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int a, int b, int[] inorder, int c, int d) {
        if (a > b || c > d) {
            return null; 
        }
        
        int root = preorder[a]; 
        TreeNode node = new TreeNode(root);
        
        int i = c; 
        
        while (c <= d && inorder[i] != root) {
            i++; 
        }
        
        int leftLen = i - c; 
        int rightLen = d - i; 
        
        node.left = helper(preorder, a + 1, a + leftLen, inorder, c, c + leftLen - 1); 
        node.right = helper(preorder, a + leftLen + 1, b, inorder, d + 1 - rightLen, d); 
        
        return node; 
    }
}
