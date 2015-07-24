/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 * 
 * Populating right next pointer in any binary tree. 
 * Different from previous problem, this is for any binary tree. However, 
 * the two levels approach works the same way. Alternating between two levels
 * and build next right pointers. 
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        List<List<TreeLinkNode>> levels = new ArrayList<List<TreeLinkNode>>(); 
        levels.add(new ArrayList<TreeLinkNode>()); 
        levels.add(new ArrayList<TreeLinkNode>()); 
        int lev0 = 0; 
        int lev1 = 1; 
        
        if (root != null) {
            levels.get(lev0).add(root); 
        }
        
        while (levels.get(lev0).size() != 0) {
            List<TreeLinkNode> curr = levels.get(lev0);
            List<TreeLinkNode> next = levels.get(lev1); 
            
            for (int i = 0; i < curr.size(); i++) {
                if (curr.get(i).left != null) {
                    next.add(curr.get(i).left); 
                }
                
                if (curr.get(i).right != null) {
                    next.add(curr.get(i).right); 
                }
                
                if (i < curr.size() - 1) {
                    curr.get(i).next = curr.get(i + 1); 
                }
            }
            
            curr.clear(); 
            lev0 = lev0 ^ lev1; 
            lev1 = lev0 ^ lev1; 
            lev0 = lev0 ^ lev1; 
        }
    }
}
