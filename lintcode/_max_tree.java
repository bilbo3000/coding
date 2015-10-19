/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     * 
     * Maintain a 单调递减 stack of tree nodes. For each new incomming value, 
     * if it is less than the top of stack value, push onto stack. Otherwise, 
     * keep poping from the stack. Let's say the poped node is mid, incomming
     * node is right, current top of stack is left. (Must true: left > mid, 
     * right > mid)
     * 
     * So, if left > right, then mid becomes left child of right, then push right 
     * onto stack; If left < right, then mid becomes right child of left, then 
     * push right onto stack. 
     * 
     * O(n) time. 
     */
    public TreeNode maxTree(int[] A) {
        // 单调递减堆栈
        Stack<TreeNode> stack = new Stack<>(); 
        int len = A.length; 
        stack.push(new TreeNode(A[0]));
        
        for (int i = 1; i <=len; i++) {
            TreeNode node = new TreeNode(Integer.MAX_VALUE);
            
            if (i < len) {
                node = new TreeNode(A[i]);
            }
            
            while (!stack.isEmpty() && stack.peek().val < node.val) {
                TreeNode nowNode = stack.pop(); 
                
                if (stack.isEmpty()) {
                    node.left = nowNode; 
                } else {
                    TreeNode left = stack.peek();
                    
                    if (left.val > node.val) {
                        node.left = nowNode; 
                    } else {
                        left.right = nowNode; 
                    }
                }
            }
            
            stack.push(node);
        }
        
        return stack.pop().left;
    }
}
