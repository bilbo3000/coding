/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     * 
     * Worse case O(n) when all the nodes are skewed. If the tree is well 
     * balanced, then it is O(logn) -- the height of the tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        TreeNode prev = null; 
        TreeNode curr = root; 
        
        while (curr != null) {
            prev = curr; 
            
            if (node.val < curr.val) {
                curr = curr.left; 
            } else {
                curr = curr.right; 
            }
        }
        
        if (prev != null) {
            if (node.val < prev.val) {
                prev.left = node; 
            } else {
                prev.right = node; 
            }
        } else {
            root = node;
        }
        
        return root; 
    }
}
