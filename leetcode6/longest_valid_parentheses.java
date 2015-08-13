/**
 * Find the longest valid parenthese. 
 * Solve is using stack. Use a stack to store index. When find a pair, pop the left 
 * half from the stack, and update the length. When find a left half, push its index 
 * to the stack. Note that when update the max, need to discuss the case where the 
 * stack is empty. 
 */ 
public class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length(); 
        
        if (len == 0) {
            return 0; 
        }
        
        Stack<Integer> stack = new Stack<>(); 
        char[] arr = s.toCharArray(); 
        int max = 0; 
        
        for (int i = 0; i < len; i++) {
            if (arr[i] == '(') {
                stack.push(i); 
            } else {
                if (stack.size() != 0 && arr[stack.peek()] == '(') {
                    stack.pop(); 
                    
                    if (stack.size() == 0) {
                        max = Math.max(max, i + 1);
                    } else {
                        max = Math.max(max, i - stack.peek()); 
                    }
                    
                } else {
                    stack.push(i); 
                }
            }
        }
        
        return max; 
    }
}
