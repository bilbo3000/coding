/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Binary tree level order traversal. Traverse the binary tree level by level and 
 * return the values of each level in a list.
 * Two levels alternating traversal approach. Each time store the value of current 
 * level to the result. 
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        List<List<TreeNode>> levels = new ArrayList<List<TreeNode>>(); 
        levels.add(new ArrayList<TreeNode>()); 
        levels.add(new ArrayList<TreeNode>()); 
        int lev0 = 0; 
        int lev1 = 1; 
        
        if (root != null) {
            levels.get(lev0).add(root); 
        }
        
        while (levels.get(lev0).size() != 0) {
            List<TreeNode> curr = levels.get(lev0); 
            List<TreeNode> next = levels.get(lev1);
            List<Integer> temp = new ArrayList<>(); 
            
            for (TreeNode item : curr) {
                temp.add(item.val); 
                
                if (item.left != null) {
                    next.add(item.left); 
                }
                
                if (item.right != null) {
                    next.add(item.right); 
                }
            }
            
            result.add(temp); 
            curr.clear(); 
            lev0 = lev0 ^ lev1; 
            lev1 = lev0 ^ lev1; 
            lev0 = lev0 ^ lev1; 
        }
        
        return result; 
    }
}
