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
        
        ArrayList<ArrayList<TreeLinkNode>> levels = new ArrayList<ArrayList<TreeLinkNode>>(); 
        levels.add(new ArrayList<TreeLinkNode>());
        levels.add(new ArrayList<TreeLinkNode>()); 
        int lev1 = 0; 
        int lev2 = 1; 
        
        levels.get(lev1).add(root); 
        
        while (levels.get(lev1).size() != 0) {
            ArrayList<TreeLinkNode> curr = levels.get(lev1);
            ArrayList<TreeLinkNode> next = levels.get(lev2); 
            
            for (int i = 0; i < curr.size() - 1; i++) {
                TreeLinkNode currNode = curr.get(i);
                TreeLinkNode nextNode = curr.get(i + 1); 
                currNode.next = nextNode; 
                
                if (currNode.left != null) {
                    next.add(currNode.left); 
                }
                
                if (currNode.right != null) {
                    next.add(currNode.right); 
                }
            }
            
            TreeLinkNode lastNode = curr.get(curr.size() - 1); 
            lastNode.next = null; 
            
            if (lastNode.left != null) {
                next.add(lastNode.left); 
            }
            
            if (lastNode.right != null) {
                next.add(lastNode.right); 
            }
            
            curr.clear(); 
            lev1 = lev1 ^ lev2; 
            lev2 = lev1 ^ lev2; 
            lev1 = lev1 ^ lev2; 
        }
    }
}
