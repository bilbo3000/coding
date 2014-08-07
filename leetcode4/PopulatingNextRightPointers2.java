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
        
        ArrayList<ArrayList<TreeLinkNode> > levels = new ArrayList<ArrayList<TreeLinkNode> >(); 
        levels.add(new ArrayList<TreeLinkNode>());
        levels.add(new ArrayList<TreeLinkNode>());
        int lev0 = 0; 
        int lev1 = 1; 
        levels.get(lev0).add(root);
        
        while (levels.get(lev0).size() != 0) {
            ArrayList<TreeLinkNode> curr = levels.get(lev0);
            ArrayList<TreeLinkNode> next = levels.get(lev1); 
            
            for (int i = 0; i < curr.size(); i++) {
                TreeLinkNode node = curr.get(i); 
                
                if (i == curr.size() - 1) {
                    node.next = null; 
                } else {
                    node.next = curr.get(i + 1); 
                }
                
                if (node.left != null) {
                    next.add(node.left); 
                }
                
                if (node.right != null) {
                    next.add(node.right); 
                }
            }
            
            curr.clear(); 
            lev0 = lev0 ^ lev1; 
            lev1 = lev0 ^ lev1; 
            lev0 = lev0 ^ lev1; 
        }
    }
}
