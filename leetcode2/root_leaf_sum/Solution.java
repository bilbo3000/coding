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
    int sum = 0; 
    
    public int sumNumbers(TreeNode root) {
        helper(root, 0); 
        return sum; 
    }
    
    public void helper(TreeNode node, int currSum) {
        if (node == null) return; 
        
        currSum = currSum * 10 + node.val; 
        
        if (node.left == null && node.right == null) {
            sum += currSum; 
            return; 
        }
        
        helper(node.left, currSum);  
        helper(node.right, currSum); 
    }
}
