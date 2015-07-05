/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Find the maximum depth of a binary tree. 
 * Comparing to recursion solution, this is an iterative solution. The idea 
 * was to use BFS to traverse through the tree, and count how many levels 
 * are in the tree. The max depth would be the number of levels in the bianry 
 * tree. 
 * The BFS uses the two-levels mechanism by alternating two levels while 
 * traversing through the tree. 
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0; 
        }
        
        int result = 0; 
        List<List<TreeNode> > levels = new ArrayList<List<TreeNode> >(); 
        levels.add(new ArrayList<TreeNode>());
        levels.add(new ArrayList<TreeNode>()); 
        int lev0 = 0; 
        int lev1 = 1; 
        List<TreeNode> curr = levels.get(lev0); 
        List<TreeNode> next = levels.get(lev1); 
        curr.add(root);
        
        while (curr.size() != 0) {
            result++; 
            
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
            curr = levels.get(lev0);
            next = levels.get(lev1);
        }
        
        return result; 
    }
}
