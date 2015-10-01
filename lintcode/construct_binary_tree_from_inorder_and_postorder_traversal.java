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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     * 
     * O(n)
     */
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
        TreeNode node = new TreeNode(root);
        int i = a; 
        
        while (i <= b && inorder[i] != root) {
           i++;  
        }
        
        int leftLen = i - a; 
        int rightLen = b - i; 
        node.left = helper(inorder, a, i - 1, postorder, c, c + leftLen - 1); 
        node.right = helper(inorder, i + 1, b, postorder, c + leftLen, c + leftLen + rightLen - 1);
        return node; 
    }
}
