public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>(); 
        int len = s.length(); 
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i); 
            
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); 
            } else {
                if (c == ')') {
                    if (stack.size() > 0 && stack.peek() == '(') {
                        stack.pop(); 
                    } else {
                        return false; 
                    }
                } else if (c == '}') {
                    if (stack.size() > 0 && stack.peek() == '{') {
                        stack.pop(); 
                    } else {
                        return false; 
                    }
                } else if (c == ']') {
                    if (stack.size() > 0 && stack.peek() == '[') {
                        stack.pop(); 
                    } else {
                        return false; 
                    }
                }
            }
        }
        
        if (stack.size() != 0) {
            return false; 
        }
        
        return true; 
    }
}
