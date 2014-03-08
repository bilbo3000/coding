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
        
        if (root == null) return result; 
        
        ArrayList<ArrayList<TreeNode>> levels = new ArrayList<ArrayList<TreeNode>>(); 
        levels.add(new ArrayList<TreeNode>()); 
        levels.add(new ArrayList<TreeNode>()); 
        int lev1 = 0; 
        int lev2 = 1; 
        levels.get(lev1).add(root);
        
        while (levels.get(lev1).size() != 0) {
            ArrayList<TreeNode> curr = levels.get(lev1); 
            ArrayList<TreeNode> next = levels.get(lev2); 
            ArrayList<Integer> temp = new ArrayList<Integer>(); 
            
            for (int i = 0; i < curr.size(); i++) {
                TreeNode node = curr.get(i); 
                temp.add(node.val); 
                
                if (node.left != null) next.add(node.left); 
                if (node.right != null) next.add(node.right); 
            }
            
            result.add(temp);
            curr.clear(); 
            lev1 = lev1 ^ lev2; 
            lev2 = lev1 ^ lev2; 
            lev1 = lev1 ^ lev2; 
        }
        
        return result; 
    }
}
