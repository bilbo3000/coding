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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>(); 
        Stack<TreeNode> s = new Stack<TreeNode>(); 
        TreeNode curr = root; 
        
        while (curr != null || s.size() != 0) {
            if (curr != null) {
                result.add(curr.val); 
                
                if (curr.right != null) {
                    s.push(curr.right); 
                } 
                
                curr = curr.left; 
            } else {
                curr = s.pop(); 
            }
        }
        
        return result; 
    }
}
