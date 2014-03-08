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
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1); 
    }
    
    public TreeNode helper(int [] inorder, int [] postorder, int a, int b, int c, int d) {
        if (a > b || c > d) return null; 
        int rootVal = postorder[d]; 
        TreeNode root = new TreeNode(rootVal);
        int index = a; 
        
        while (index <= b) {
            if (inorder[index] == rootVal) break; 
            index++; 
        }
        
        root.left = helper(inorder, postorder, a, index - 1, c, c + index - a - 1); 
        root.right = helper(inorder, postorder, index + 1, b, d - b + index, d - 1);
        
        return root; 
    }
}
