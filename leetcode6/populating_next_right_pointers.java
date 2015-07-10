/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 * 
 * Build next pointers for a binary tree. 
 * 
 * The idea was to use the two-level approach. Alternating between 
 * two levels in a BFS fashion and build next pointers one level 
 * at a time. 
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
            
            for (int i = 0; i < curr.size() - 1; i++) {
                curr.get(i).next = curr.get(i + 1); 
            }
            
            for (TreeLinkNode item : curr) {
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
    }
}
