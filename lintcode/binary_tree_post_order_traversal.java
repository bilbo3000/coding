/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * Two stacks. 
 * O(n). 
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        Stack<TreeNode> s1 = new Stack<TreeNode>(); 
        Stack<TreeNode> s2 = new Stack<TreeNode>(); 
        
        if (root != null) {
            s1.push(root);
        }
        
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
