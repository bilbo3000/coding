/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Flattern binary tree to linked list. 
 * The idea was to traverse the linked list in order with two pointers. 
 * When processing each node, store its right child in stack, move 
 * left child to replace right child and set left to null. Then move 
 * onto to processing right child. Advance the prev pointer accordingly. 
 * When reaches null, pop one node from the stack and attach to prev. Then 
 * continue the in order processing. 
 */
public class Solution {
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
                if (prev != null) {
                    prev.right = curr; 
                }
            }
        }
    }
}
