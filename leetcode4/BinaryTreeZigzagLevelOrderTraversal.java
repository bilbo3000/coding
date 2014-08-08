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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer> > result = new ArrayList<List<Integer> >(); 
        List<List<TreeNode> > levels = new ArrayList<List<TreeNode> >(); 
        levels.add(new ArrayList<TreeNode>());
        levels.add(new ArrayList<TreeNode>());
        int lev0 = 0; 
        int lev1 = 1; 
        
        if (root == null) {
            return result; 
        }
        
        levels.get(lev0).add(root);
        int cnt = 0;
        
        while (levels.get(lev0).size() != 0) {
            List<TreeNode> curr = levels.get(lev0); 
            List<TreeNode> next = levels.get(lev1);
            List<Integer> row = new ArrayList<Integer>(); 
            
            for (TreeNode node : curr) {
                row.add(node.val); 
                
                if (node.left != null) {
                    next.add(node.left); 
                }
                
                if (node.right != null) {
                    next.add(node.right); 
                }
            }
            
            if (cnt % 2 != 0) {
                Collections.reverse(row); 
            }
            
            result.add(row);
            curr.clear(); 
            cnt++; 
            lev0 = lev0 ^ lev1; 
            lev1 = lev0 ^ lev1; 
            lev0 = lev0 ^ lev1; 
        }
        
        return result; 
    }
}
