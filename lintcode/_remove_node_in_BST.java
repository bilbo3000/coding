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
 * 
 * O(logn)
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        TreeNode curr = root; 
        TreeNode prev = null; 
        
        while (curr != null && curr.val != value) {
            prev = curr; 
            
            if (curr.val > value) {
                curr = curr.left; 
            } else {
                curr = curr.right;
            }
        }
        
        if (curr == null) {
            return root; 
        }
        
        // Need to delete curr
        TreeNode newCurr = null; 
        
        if (curr.left == null) {
            newCurr = curr.right; 
        } else if (curr.right == null) {
            newCurr = curr.left; 
        } else {
            TreeNode temp = curr.right; 
            
            while (temp.left != null) {
                temp = temp.left; 
            }
            
            temp.left = curr.left; 
            newCurr = curr.right; 
        }
        
        if (prev == null) {
            return newCurr; 
        } else {
            if (curr == prev.left) {
                prev.left = newCurr; 
            } else {
                prev.right = newCurr; 
            }
        }
        
        return root; 
    }
}
