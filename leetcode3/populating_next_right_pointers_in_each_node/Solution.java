/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        ArrayList<ArrayList<TreeLinkNode>> levels = new ArrayList<ArrayList<TreeLinkNode>>(); 
        levels.add(new ArrayList<TreeLinkNode>()); 
        levels.add(new ArrayList<TreeLinkNode>()); 
        int lev1 = 0; 
        int lev2 = 1; 
        
        if (root != null) {
            levels.get(lev1).add(root); 
        }
        
        while (levels.get(lev1).size() != 0) {
            ArrayList<TreeLinkNode> curr = levels.get(lev1); 
            ArrayList<TreeLinkNode> next = levels.get(lev2); 
            
            for (int i = 0; i < curr.size(); i++) {
                if (i < curr.size() - 1) {
                    curr.get(i).next = curr.get(i + 1); 
                }
                
                if (curr.get(i).left != null) {
                    next.add(curr.get(i).left); 
                }
                
                if (curr.get(i).right != null) {
                    next.add(curr.get(i).right); 
                }
            }
            
            curr.clear(); 
            lev1 = lev1 ^ lev2; 
            lev2 = lev1 ^ lev2; 
            lev1 = lev1 ^ lev2; 
        }
    }
}
