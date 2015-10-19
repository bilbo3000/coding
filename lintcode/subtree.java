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
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     * 
     * O(n * m)
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T2 == null) {
            return true; 
        }
        
        Stack<TreeNode> stack = new Stack<>(); 
        TreeNode curr = T1; 
        
        while (curr != null || stack.size() != 0) {
            if (curr != null) {
                boolean res = isSame(curr, T2);
                
                if (res) {
                    return true; 
                }
                
                stack.push(curr);
                curr = curr.left; 
            } else {
                curr = stack.pop(); 
                curr = curr.right; 
            }
        }
        
        return false; 
    }
    
    private boolean isSame(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 == null) {
            return true; 
        }
        
        if (T1 == null || T2 == null) {
            return false; 
        }
        
        if (T1.val != T2.val) {
            return false; 
        }
        
        return isSame(T1.left, T2.left) && isSame(T1.right, T2.right);
    }
}
