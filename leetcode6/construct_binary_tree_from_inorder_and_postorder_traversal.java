/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Construct a binary search tree from a inorder and postorder traversal. 
 * Solve it recursively. Use two pointers to referrence to current segment
 * we are current working with. Each time, the last element in postorder 
 * would be the root. Then find that element element in inorder. Then 
 * split inorder at that element and recursively process left and right parts.
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1); 
    }
    
    private TreeNode helper(int[] inorder, int a, int b, int[] postorder, int c, int d) {
        if (a > b || c > d) {
            return null; 
        }
        
        if (a == b || c == d) {
            return new TreeNode(inorder[a]);
        }
        
        int root = postorder[d]; 
        int i = a; 
        
        while (i <= b && inorder[i] != root) {
            i++; 
        }
        
        int leftLen = i - a; 
        int rightLen = b - i; 
        
        TreeNode node = new TreeNode(root);
        node.left = helper(inorder, a, i - 1, postorder, c, c + leftLen - 1); 
        node.right = helper(inorder, i + 1, b, postorder, c + leftLen, c + leftLen + rightLen - 1); 
        
        return node; 
    }
}
