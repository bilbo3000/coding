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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        
        if (root == null) return result; 
        
        Stack<TreeNode> s1 = new Stack<TreeNode>(); 
        Stack<TreeNode> s2 = new Stack<TreeNode>(); 
        s1.push(root);
        
        while (s1.size() != 0) {
            TreeNode curr = s1.pop(); 
            s2.push(curr); 
            
            if (curr.left != null) s1.push(curr.left); 
            if (curr.right != null) s1.push(curr.right); 
        }
        
        while (s2.size() != 0) {
            TreeNode curr = s2.pop(); 
            result.add(curr.val); 
        }
        
        return result; 
    }
}
