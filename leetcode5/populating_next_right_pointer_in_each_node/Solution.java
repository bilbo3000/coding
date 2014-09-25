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
        if (root == null) {
            return; 
        }
        
        List<List<TreeLinkNode>> levels = new ArrayList<List<TreeLinkNode>>(); 
        levels.add(new ArrayList<TreeLinkNode>());
        levels.add(new ArrayList<TreeLinkNode>()); 
        int lev0 = 0; 
        int lev1 = 1; 
        levels.get(lev0).add(root);
        
        while (levels.get(lev0).size() != 0) {
            List<TreeLinkNode> curr = levels.get(lev0); 
            List<TreeLinkNode> next = levels.get(lev1);
            
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
            lev0 = lev0 ^ lev1; 
            lev1 = lev0 ^ lev1; 
            lev0 = lev0 ^ lev1; 
        }
    }
}
