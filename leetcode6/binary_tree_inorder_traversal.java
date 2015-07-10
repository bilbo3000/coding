/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Iterative binary tree inorder traversal. 
 * 
 * The idea was to use a stack to store each node while traversing through the 
 * tree. For the current node, store it in the stack and move onto its left 
 * child. Keep doing this until hit null, pop the parent to be current, visit 
 * that node, and move on to its right child. Then so on so forth. 
 * 
 * Key template code: 
 * while (curr != null || stack.size() != 0) { ... }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); 
        TreeNode curr = root;
        Stack<TreeNode> s = new Stack<>(); 
        
        while (curr != null || s.size() != 0) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left; 
            } else {
                curr = s.pop(); 
                result.add(curr.val);
                curr = curr.right; 
            }
        }
        
        return result; 
    }
}
