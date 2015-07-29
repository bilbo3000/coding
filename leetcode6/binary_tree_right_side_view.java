/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Return the list of values for the right frontier nodes of a binary tree. 
 * The idea was to use alternating level BFS traversal. At each level, save 
 * the rightmost element in the result list. 
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>(); 
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
            result.add(curr.get(curr.size() - 1).val); 
            
            for (TreeNode item : curr) {
                if (item.left != null) {
                    next.add(item.left); 
                }
                
                if (item.right != null) {
                    next.add(item.right); 
                }
            }
            
            curr.clear(); 
            lev0 = lev0 ^ lev1; 
            lev1 = lev0 ^ lev1; 
            lev0 = lev0 ^ lev1; 
        }
        
        return result; 
    }
}
