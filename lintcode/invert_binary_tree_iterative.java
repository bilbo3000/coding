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
     * Iterative solution. In order traverse the tree. When poping and processing
     * each node, invert left and right subtree. And then move on to the LEFT child,
     * because it has been inverted.
     * O(n) because it visits every node to invert.
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        TreeNode curr = root; 
        Stack<TreeNode> stack = new Stack<>(); 
        
        while (curr != null || stack.size() != 0) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left; 
            } else {
                curr = stack.pop(); 
                TreeNode temp = curr.left; 
                curr.left = curr.right; 
                curr.right = temp; 
                curr = curr.left; 
            }
        }
    }
}
