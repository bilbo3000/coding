import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Post order traversal iteratively -- using two stacks. 
 * 
 * First stack stores elements that still need to be processed. Once popped from 
 * the first stack, put its right followed by its left into the first stack and 
 * push itself onto the second stack. The idea was we want to print right hand first, 
 * thus need to push right to first stack before left, so right got popped after left, and 
 * will be higher on the second stack, and thus printed early. 
 * 
 * Time: O(n), visit each node; 
 * Space: O(n), worst case skewed tree, and all elements are pushed onto stack. 
 */
public class Solution {
	
    public List<Integer> postOrderTraversal(TreeNode root) {    
    	List<Integer> res = new ArrayList<>(); 
    	if (root == null) {
    		return res;
    	}
    	
    	Stack<TreeNode> s1 = new Stack<>(); 
    	Stack<TreeNode> s2 = new Stack<>(); 
    	
    	s1.add(root); 
    	
    	while(!s1.isEmpty()) {
    		TreeNode curr = s1.pop(); 
    		
    		if (curr.right != null) {
    			s1.push(curr.right);
    		}
    		
    		if (curr.left != null) {
    			s1.push(curr.left);
    		}
    		
    		s2.push(curr); 
    	}
    	
    	while (s2.size() != 0) {
    		res.add(s2.pop().value);
    	}
    	
    	return res; 
    }
}
