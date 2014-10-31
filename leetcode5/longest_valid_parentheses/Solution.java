public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>(); 
        int result = 0; 
        int last = -1;  // Index of last )
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                stack.push(i); 
            } else {
                if (stack.size() != 0) {
                    stack.pop(); 
                    if (stack.size() != 0) {
                        result = Math.max(result, i - stack.peek()); 
                    } else {
                        result = Math.max(result, i - last);
                    }
                } else {
                    last = i; 
                }
            }
        }
        
        return result; 
    }
}
