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
        List<List<Integer> > result = new ArrayList<List<Integer> >(); 
        helper(root, sum, new ArrayList<Integer>(), result); 
        
        return result; 
    }
    
    private void helper(TreeNode node, int val, List<Integer> path, List<List<Integer> > result) {
        if (node == null) {
            return; 
        }
        
        path.add(node.val);
        if (node.left == null && node.right == null && node.val == val) {
            result.add(new ArrayList<Integer>(path)); 
        } else {
            helper(node.right, val - node.val, path, result); 
            helper(node.left, val - node.val, path, result); 
        }
        
        path.remove(path.size() - 1); 
    }
}
