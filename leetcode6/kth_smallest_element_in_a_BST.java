/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Find the kth smallest element in BST. 
 * The idea was to run iterative inorder binary tree traversal 
 * and increment the count each time when there's a pop from 
 * the stack. When the count equals to k, break and return 
 * the value. 
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>(); 
        TreeNode curr = root; 
        int count = 0; 
        
        while (curr != null || stack.size() != 0) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left; 
            } else {
                curr = stack.pop(); 
                count++; 
                
                if (count == k) {
                    break;  
                }
                
                curr = curr.right; 
            }
        }
        
        return curr.val; 
    }
}
