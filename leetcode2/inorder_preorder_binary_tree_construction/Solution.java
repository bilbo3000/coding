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
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1); 
    }
    
    public TreeNode helper(int [] preorder, int [] inorder, int a, int b, int c, int d) {
        if (a > b || c > d) return null; 
        
        int rootVal = preorder[a]; 
        TreeNode root = new TreeNode(rootVal); 
        int index = c; 
        
        while (index <= d) {
            if (inorder[index] == rootVal) break; 
            index++; 
        }
        
        root.left = helper(preorder, inorder, a + 1, a + index - c, c, index - 1); 
        root.right = helper(preorder, inorder, b - d + index + 1, b, index + 1, d); 
        
        return root; 
    }
}
