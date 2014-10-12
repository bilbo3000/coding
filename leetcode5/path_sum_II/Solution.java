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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        
        helper(result, new ArrayList<Integer>(), root, sum);
        
        return result; 
    }
    
    private void helper(List<List<Integer>> result, List<Integer> path, TreeNode currNode, int sum) {
        if (currNode == null) {
            return; 
        }
        
        path.add(currNode.val);
        
        if (currNode.left == null && currNode.right == null && currNode.val == sum) {
            result.add(path); 
            
            return; 
        }
        
        if (currNode.left != null) {
            List<Integer> temp = new ArrayList<Integer>(path);
            helper(result, temp, currNode.left, sum - currNode.val); 
        }
        
        if (currNode.right != null) {
            List<Integer> temp = new ArrayList<Integer>(path);
            helper(result, temp, currNode.right, sum - currNode.val); 
        }
    }
}
