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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        ArrayList<ArrayList<TreeNode>> levels = new ArrayList<ArrayList<TreeNode>>(); 
        levels.add(new ArrayList<TreeNode>()); 
        levels.add(new ArrayList<TreeNode>()); 
        int lev1 = 0; 
        int lev2 = 1; 
        
        if (root == null) {
            return result; 
        }
        
        levels.get(lev1).add(root);
        
        while (levels.get(lev1).size() != 0) {
            ArrayList<TreeNode> curr = levels.get(lev1); 
            ArrayList<TreeNode> next = levels.get(lev2);
            ArrayList<Integer> currLevel = new ArrayList<Integer>(); 
            
            for (int i = 0; i < curr.size(); i++) {
                TreeNode temp = curr.get(i); 
                currLevel.add(temp.val); 
                
                if (temp.left != null) {
                    next.add(temp.left); 
                }
                
                if (temp.right != null) {
                    next.add(temp.right); 
                }
            }
            
            result.add(currLevel);
            curr.clear(); 
            lev1 = lev1 ^ lev2; 
            lev2 = lev1 ^ lev2; 
            lev1 = lev1 ^ lev2; 
        }
        
        return result; 
    }
}
