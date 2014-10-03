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
    public int sumNumbers(TreeNode root) {
        List<List<TreeNode>> levels = new ArrayList<List<TreeNode>>(); 
        levels.add(new ArrayList<TreeNode>());
        levels.add(new ArrayList<TreeNode>());
        int lev0 = 0; 
        int lev1 = 1; 
        
        if (root == null) {
            return 0; 
        }
        
        levels.get(lev0).add(root);
        int result = 0; 
        
        while (levels.get(lev0).size() != 0) {
            List<TreeNode> curr = levels.get(lev0);
            List<TreeNode> next = levels.get(lev1);
            
            for (TreeNode node : curr) {
                if (node.left == null && node.right == null) {
                    result += node.val; 
                }
                
                if (node.left != null) {
                    node.left.val += node.val * 10; 
                    next.add(node.left); 
                }
                
                if (node.right != null) {
                    node.right.val += node.val * 10; 
                    next.add(node.right); 
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
