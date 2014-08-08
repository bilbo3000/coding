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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true; 
        }
        
        ArrayList<ArrayList<TreeNode> > levels = new ArrayList<ArrayList<TreeNode> >(); 
        levels.add(new ArrayList<TreeNode>());
        levels.add(new ArrayList<TreeNode>());
        int lev0 = 0; 
        int lev1 = 1; 
        levels.get(lev0).add(root); 
        
        while (levels.get(lev0).size() != 0) {
            ArrayList<TreeNode> curr = levels.get(lev0); 
            ArrayList<TreeNode> next = levels.get(lev1); 
            
            int i = 0; 
            int j = curr.size() - 1; 
            
            while (i < j) {
                TreeNode nodeLeft = curr.get(i);
                TreeNode nodeRight = curr.get(j); 
                
                if (nodeLeft == null || nodeRight == null) {
                    if (nodeLeft != nodeRight) {
                        return false; 
                    }
                } else {
                    if (nodeLeft.val != nodeRight.val) {
                        return false; 
                    }
                }
                
                i++; 
                j--; 
            }
            
            for (TreeNode item : curr) {
                if (item != null) {
                    next.add(item.left);
                    next.add(item.right); 
                }
            }
            
            curr.clear(); 
            lev0 = lev0 ^ lev1; 
            lev1 = lev0 ^ lev1; 
            lev0 = lev0 ^ lev1; 
        }
        
        return true; 
    }
}
