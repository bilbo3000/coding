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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        Stack<TreeNode> s = new Stack<TreeNode>(); 
        
        if (root != null) {
            s.push(root); 
        }
        
        while (s.size() != 0) {
            TreeNode curr = s.pop(); 
            result.add(0, curr.val); 
            
            if (curr.left != null) {
                s.push(curr.left); 
            }
            
            if (curr.right != null) {
                s.push(curr.right); 
            }
        }
        
        return result; 
    }
}
