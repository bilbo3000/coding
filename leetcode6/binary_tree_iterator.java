/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Implement an iterator of a binary search tree featuring hasNext and next method. 
 * The idea was to iterate through the BST in the in order traversal style. Thus, 
 * we need to maintain a current pointer and a stack. HasNext just checks whether 
 * curr is null or the stack is empty. Next will break once hasNext return false,
 * or it successfully processed next element. 
 */

public class BSTIterator {
    
    TreeNode curr = null; 
    Stack<TreeNode> stack = new Stack<TreeNode>(); 

    public BSTIterator(TreeNode root) {
        curr = root; 
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return curr != null || !stack.empty(); 
    }

    /** @return the next smallest number */
    public int next() {
        int result = 0; 
        
        while (hasNext()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left; 
            } else {
                curr = stack.pop(); 
                result = curr.val; 
                curr = curr.right; 
                break; 
            }
        }
        
        return result; 
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
