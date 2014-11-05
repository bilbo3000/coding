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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true; 
        }
        
        TreeNode left = root.left; 
        TreeNode right = root.right; 
        
        if (left == null || right == null) {
            if (left == right) {
                return true; 
            } else {
                return false; 
            }
        }
        
        Stack<TreeNode> s1 = new Stack<TreeNode>(); 
        Stack<TreeNode> s2 = new Stack<TreeNode>(); 
        
        while (left != null || s1.size() != 0) {
            if (left != null) {
                if (right == null || left.val != right.val) {
                    return false; 
                }
                
                s1.push(left);
                s2.push(right); 
                left = left.left; 
                right = right.right; 
            } else {
                if (s2.size() == 0 || right != null) {
                    return false; 
                }
                
                left = s1.pop(); 
                right = s2.pop(); 
                left = left.right; 
                right = right.left; 
            }
        }
        
        if (right != null || s2.size() != 0) {
            return false; 
        }
        
        return true; 
    }
}
