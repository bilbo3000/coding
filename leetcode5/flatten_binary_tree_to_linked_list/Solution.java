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
        TreeNode curr = root; 
        TreeNode prev = null; 
        Stack<TreeNode> s = new Stack<TreeNode>(); 
        
        while (curr != null || s.size() != 0) {
            if (curr != null) {
                if (curr.right != null) {
                    s.push(curr.right);
                }
                
                curr.right = curr.left; 
                curr.left = null; 
                prev = curr; 
                curr = curr.right;
            } else {
                curr = s.pop(); 
                prev.right = curr; 
            }
        }
    }
}
