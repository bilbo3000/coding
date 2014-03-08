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
    
    public TreeNode helper(int[] num, int i, int j) {
        if (i > j) return null; 
        if (i == j) return new TreeNode(num[i]); 
        
        int mid = (i + j) / 2; 
        TreeNode node = new TreeNode(num[mid]); 
        node.left = helper(num, i, mid - 1); 
        node.right = helper(num, mid + 1, j); 
        
        return node; 
    } 
}
