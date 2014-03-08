/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return helper(1, n); 
    }
    
    private ArrayList<TreeNode> helper(int left, int right) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>(); 
        
        if (left > right) {
            result.add(null); 
            return result; 
        }
        
        for (int i = left; i <= right; i++) {
            ArrayList<TreeNode> leftResult = helper(left, i - 1); 
            ArrayList<TreeNode> rightResult = helper(i + 1, right); 
            
            for (TreeNode leftNode : leftResult) {
                for (TreeNode rightNode : rightResult) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode; 
                    root.right = rightNode; 
                    result.add(root); 
                }
            }
        }
        
        return result; 
    }
}
