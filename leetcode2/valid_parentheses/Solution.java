public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>(); 
        int len = s.length(); 
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i); 
            
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); 
            }
            else {
                if (stack.size() != 0) {
                    char peek = stack.peek(); 
                    
                    if ((peek == '(' && c == ')') || 
                        (peek == '{' && c == '}') || 
                        (peek == '[' && c == ']')) {
                        stack.pop(); 
                    }
                    else {
                        return false; 
                    }
                }
                else {
                    return false; 
                }
            }
            
        }
        
        return stack.size() == 0 ? true : false;
    }
}
