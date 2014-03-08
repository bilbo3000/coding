public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0; 
        int last = -1; 
        Stack<Integer> stack = new Stack<Integer>(); 
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            
            if (c == '(') {
                stack.push(i); 
            }
            else {
                if (stack.size() == 0) {
                    last = i; 
                }
                else {
                    stack.pop(); 
                    
                    if (stack.size() == 0) {
                        max = Math.max(max, i - last); 
                    }
                    else {
                        max = Math.max(max, i - stack.peek()); 
                    }
                }
            }
        }
        
        return max; 
    }
}
