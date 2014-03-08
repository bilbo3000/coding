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
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum, new ArrayList<Integer>()); 
        return result; 
    }
    
    public void helper(TreeNode root, int sum, ArrayList<Integer> curr) {
        if (root == null) return; 
        
        ArrayList<Integer> temp = new ArrayList<Integer>(curr); 
        temp.add(root.val); 
        
        if (root.val == sum && root.left == null && root.right == null) {
            result.add(temp); 
        }
        else {
            helper(root.left, sum - root.val, temp);
            helper(root.right, sum - root.val, temp); 
        }
    }
}
