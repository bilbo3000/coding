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
    public TreeNode sortedArrayToBST(int[] num) {
        return helper(num, 0, num.length - 1); 
    }
    
    private TreeNode helper(int[] num, int a, int b) {
        if (a > b) {
            return null; 
        }
        
        int mid = (a + b) / 2; 
        TreeNode root = new TreeNode(num[mid]); 
        root.left = helper(num, a, mid - 1); 
        root.right = helper(num, mid + 1, b); 
        
        return root; 
    }
}