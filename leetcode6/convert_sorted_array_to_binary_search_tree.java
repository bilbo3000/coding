/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Convert a sorted array to a balanced binary search tree. 
 * Divide and conque approach. During each recursion level, find the 
 * middle number as the root, then recursive to generate left and right 
 * subtrees for left subarray and right subarray accordingly. 
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1); 
    }
    
    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null; 
        }
        
        if (left == right) {
            return new TreeNode(nums[left]); 
        }
        
        int mid = (left + right) / 2; 
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1); 
        node.right = helper(nums, mid + 1, right); 
        
        return node; 
    }
}
