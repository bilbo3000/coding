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
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        Stack<TreeNode> s = new Stack<TreeNode>(); 
        TreeNode curr = root; 
        
        while (curr != null || s.size() != 0) {
            if (curr != null) {
                result.add(curr.val); 
                s.push(curr); 
                curr = curr.left; 
            } else {
                curr = s.pop(); 
                curr = curr.right; 
            }
        }
        
        return result; 
    }
}
