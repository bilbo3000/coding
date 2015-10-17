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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     * 
     * Iterative pre-order tree traversal. 
     * O(n)
     */
    public void flatten(TreeNode root) {
        TreeNode prev = null; 
        TreeNode curr = root; 
        Stack<TreeNode> stack = new Stack<>(); 
        
        while (curr != null || stack.size() != 0) {
            if (curr != null) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                
                curr.right = curr.left; 
                curr.left = null; 
                prev = curr; 
                curr = curr.right; 
            } else {
                curr = stack.pop();
                prev.right = curr; 
            }
        }
    }
}
