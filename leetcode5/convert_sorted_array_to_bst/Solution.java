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
    
    private TreeNode helper(int[] num, int l, int r) {
        if (l > r) {
            return null; 
        }
        
        if (l == r) {
            return new TreeNode(num[l]); 
        }
        
        int mid = (l + r) / 2; 
        TreeNode node = new TreeNode(num[mid]); 
        node.left = helper(num, l, mid - 1); 
        node.right = helper(num, mid + 1, r); 
        
        return node; 
    }
}
