/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Recover binary search tree. 
 * The idea was to traverse the tree in order via two pointers. When we find the first 
 * pair out of order node, we set "first" points to prev (LARGER one) and 'second' points
 * to node (SMALLER one). If we cannot find second pair our of order nodes, which means 
 * the two out of order nodes are right next to each other in inorder traversal. However, 
 * if we can find the second pair out of order nodes, we replace second with node (SMALLER 
 * one). In the end, first will point to the larger one and second will point to the smaller
 * one and we just need to swap the values of the two nodes. 
 */
public class Solution {
    private TreeNode first = null; 
    private TreeNode second = null; 
    private TreeNode prev = null; 
    
    public void recoverTree(TreeNode root) {
        inorder(root); 
        
        int temp = first.val; 
        first.val = second.val; 
        second.val = temp; 
    }
    
    private void inorder(TreeNode node) {
        if (node == null) {
            return; 
        }
        
        inorder(node.left);
        
        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev; 
                second = node; 
            } else {
                second = node; 
            }
        }
        
        prev = node; 
        inorder(node.right); 
    }
}
