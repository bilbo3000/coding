/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Find the max path sum in a binary tree where the path can start and end 
 * at any nodes. 
 * Solve it recursively, but also maintain a global max. Each recursive call 
 * will return the max between the node value, the node value plus left child 
 * returned value and the node value plus the right child returned value. 
 * We also need to update the global max between global max, the max value 
 * that is going to be returned, the node value plus both left and right child 
 * returned values. 
 */
public class Solution {
    private int max = Integer.MIN_VALUE; 
    
    public int maxPathSum(TreeNode root) {
        helper(root);
        
        return max; 
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0; 
        }
        
        int maxx = root.val; 
        int left = helper(root.left);
        int right = helper(root.right); 
        
        maxx = Math.max(maxx, root.val + left);
        maxx = Math.max(maxx, root.val + right);
        
        max = Math.max(max, maxx); 
        max = Math.max(max, left + root.val + right); 
        
        return maxx; 
    }
}
