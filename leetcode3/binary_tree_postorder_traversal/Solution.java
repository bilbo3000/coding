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
        Stack<TreeNode> s1 = new Stack<TreeNode>(); 
        Stack<TreeNode> s2 = new Stack<TreeNode>(); 
        
        if (root == null) {
            return result; 
        }
        
        s1.push(root);
        
        while (s1.size() != 0) {
            TreeNode curr = s1.pop(); 
            
            if (curr.left != null) {
                s1.push(curr.left);  
            }
            
            if (curr.right != null) {
                s1.push(curr.right); 
            }
            
            s2.push(curr); 
        }
        
        while (s2.size() != 0) {
            result.add(s2.pop().val); 
        }
        
        return result; 
    }
}
