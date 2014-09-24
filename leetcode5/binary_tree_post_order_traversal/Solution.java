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
        Stack<TreeNode> s1 = new Stack<TreeNode>(); 
        Stack<TreeNode> s2 = new Stack<TreeNode>(); 
        List<Integer> result = new ArrayList<Integer>(); 
        
        if (root == null) {
            return result; 
        }
        
        s1.add(root);
        
        while (s1.size() != 0) {
            TreeNode temp = s1.pop(); 
            
            if (temp.left != null) {
                s1.push(temp.left); 
            }
            
            if (temp.right != null) {
                s1.push(temp.right); 
            }
            
            s2.push(temp); 
        }
        
        while (s2.size() != 0) {
            result.add(s2.pop().val); 
        }
        
        return result; 
    }
}
