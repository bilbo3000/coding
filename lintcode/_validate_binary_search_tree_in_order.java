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
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     * 
     * In order traverse the tree, if current node is always greater than 
     * previous node, then it is a validate binary search tree. 
     * 
     * Time complexity O(n); Space complexity O(logn)
     */
    public boolean isValidBST(TreeNode root) {
        TreeNode prev = null; 
        TreeNode curr = root; 
        Stack<TreeNode> stack = new Stack<>(); 
        
        while (stack.size() != 0 || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left; 
            } else {
                curr = stack.pop(); 
                
                if (prev != null && prev.val >= curr.val) {
                    return false; 
                }
                
                prev = curr; 
                curr = curr.right; 
            }
        }
        
        return true; 
    }
}
