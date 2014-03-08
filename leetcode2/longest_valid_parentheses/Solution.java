public class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length(); 
        Stack<Integer> stack = new Stack<Integer>(); 
        int lastLeft = -1; 
        int max = 0; 
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i); 
            
            if (c == '(') {
                stack.push(i); 
            }
            else {  // ')'
                if (stack.size() != 0) {
                    stack.pop(); 
                    
                    if (stack.size() != 0) {
                        max = Math.max(max, i - stack.peek()); 
                    }
                    else {
                        max = Math.max(max, i - lastLeft); 
                    }
                }
                else {
                    lastLeft = i; 
                }
            }
        }
        
        return max; 
    }
}
