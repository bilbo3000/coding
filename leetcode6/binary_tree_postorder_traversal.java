/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Post order traversal of BST. 
 * The idea was to use two stacks. The first stack is used to temporarily 
 * store nodes whose children has not been processed. The second stack is
 * used to store nodes in post traversal order. 
 * while process each node, first pop from first stack, put its left and 
 * then right child to the first stack, then put this node to second stack. 
 * Until there's no more nodes to process in the first node. The nodes 
 * left in the second stack would be in post-order traversal order. 
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); 
        Stack<TreeNode> stack1 = new Stack<>(); 
        Stack<TreeNode> stack2 = new Stack<>(); 
        
        if (root != null) {
            stack1.push(root); 
        }
        
        while (stack1.size() != 0) {
            TreeNode curr = stack1.pop(); 
            
            if (curr.left != null) {
                stack1.push(curr.left);
            }
            
            if (curr.right != null) {
                stack1.push(curr.right); 
            }
            
            stack2.push(curr); 
        }
        
        while (stack2.size() != 0) {
            result.add(stack2.pop().val); 
        }
        
        return result; 
    }
}
