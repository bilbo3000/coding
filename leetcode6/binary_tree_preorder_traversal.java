/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Pre-order traversal of a binary tree. 
 * 
 * The iterative solution is to use a stack. The idea is, for the 
 * current node, visit it and put it to the stack, then move on to 
 * the left child. The reason to put on the stack is that once we 
 * exhaust left child (and onward), we can get current node back 
 * from the stack and move onto its right child. 
 * 
 * The skeleton looks like: 
 * while (curr != null || !s.empty()) {
 *     // do something     
 *}
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode curr = root; 
        Stack<TreeNode> s = new Stack<>(); 
        List<Integer> result = new ArrayList<>(); 
        
        while (curr != null || !s.empty()) {
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
