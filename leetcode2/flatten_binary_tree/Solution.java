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
    public void flatten(TreeNode root) {
        if (root == null) return; 
        
        Stack<TreeNode> s = new Stack<TreeNode>(); 
        TreeNode curr = root; 
        TreeNode prev = null; 
        
        while (curr != null || s.size() != 0) {
            if (curr != null) {
                s.push(curr.right); 
                curr.right = curr.left; 
                curr.left = null; 
                prev = curr; 
                curr = curr.right; 
            }
            else {
                curr = s.pop(); 
                prev.right = curr; 
            }
        }
        
    }
}
