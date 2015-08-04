/**
 * Check if the given string contains valid pairs formation of parenthese. 
 * Solve it using a stack. Go through each parenthese. If it is left part, 
 * push onto stack. If it is right part, pop stack if top of stack pair up 
 * with current one. After successfully process through the input, we need 
 * to check if the stack is empty. If not, it must be invalid. 
 */ 
public class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> m = new HashMap<>(); 
        m.put(')', '(');
        m.put('}', '{');
        m.put(']', '[');
        
        Stack<Character> stack = new Stack<>(); 
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); 
            } else {
                if (stack.size() == 0) {
                    return false; 
                } else {
                    char top = stack.pop(); 
                    
                    if (top != m.get(c)) {
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
