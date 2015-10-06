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
 * Example of iterate a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class Solution {
    private Stack<TreeNode> stack = new Stack<TreeNode>(); 
    private TreeNode curr = null; 
    
    //@param root: The root of binary tree.
    public Solution(TreeNode root) {
        if (root != null) {
            curr = root;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return curr != null || stack.size() != 0; 
    }
    
    //@return: return next node
    public TreeNode next() {
        TreeNode result = null; 
        
        while (curr != null || stack.size() != 0) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                result = stack.pop(); 
                curr = result.right; 
                break; 
            }
        }
        
        return result; 
    }
}
