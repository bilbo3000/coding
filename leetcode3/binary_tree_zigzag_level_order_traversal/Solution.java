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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        ArrayList<ArrayList<TreeNode>> levels = new ArrayList<ArrayList<TreeNode>>(); 
        levels.add(new ArrayList<TreeNode>());
        levels.add(new ArrayList<TreeNode>()); 
        int lev1 = 0; 
        int lev2 = 1; 
        int cnt = 0; 
        
        if (root == null) {
            return result; 
        }
        
        levels.get(lev1).add(root);
        
        while (levels.get(lev1).size() != 0) {
            ArrayList<TreeNode> curr = levels.get(lev1);
            ArrayList<TreeNode> next = levels.get(lev2);
            ArrayList<Integer> currLine = new ArrayList<Integer>(); 
            cnt++; 
            
            for (int i = 0; i < curr.size(); i++) {
                TreeNode node = curr.get(i); 
                currLine.add(node.val); 
                
                if (node.left != null) {
                    next.add(node.left); 
                }
                
                if (node.right != null) {
                    next.add(node.right); 
                }
            }
            
            if (cnt % 2 == 0) {
                Collections.reverse(currLine); 
            }
            
            result.add(currLine); 
            curr.clear(); 
            lev1 = lev1 ^ lev2; 
            lev2 = lev1 ^ lev2; 
            lev1 = lev1 ^ lev2; 
        } 
        
        return result; 
    }
}
