/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        List<TreeNode> inorder = new ArrayList<TreeNode>(); 
        TreeNode curr = root; 
        Stack<TreeNode> s = new Stack<TreeNode>(); 
        
        while (curr != null || s.size() != 0) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left; 
            } else {
                curr = s.pop(); 
                inorder.add(curr); 
                curr = curr.right; 
            }
        }
        
        TreeNode left = null; 
        TreeNode right = null; 
        
        for (int i = 0; i < inorder.size(); i++) {
            if (i < inorder.size() - 1 && inorder.get(i).val > inorder.get(i + 1).val) {
                left = inorder.get(i); 
                break; 
            }
        }
        
        for (int i = inorder.size() - 1; i >= 0; i--) {
            if (i > 0 && inorder.get(i).val < inorder.get(i - 1).val) {
                right = inorder.get(i); 
                break; 
            }
        }
        
        if (left != null && right != null) {
            int temp = left.val; 
            left.val = right.val; 
            right.val = temp; 
        }
    }
}
