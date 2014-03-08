public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>(); 
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            
            if (c == '(' || c == '{' || c == '[') {
                stk.push(c); 
            }
            else {
                if (stk.size() == 0) {
                    return false; 
                }
                
                if (stk.peek() == '(' && c == ')'
                || stk.peek() == '{' && c == '}'
                || stk.peek() == '[' && c == ']') {
                    stk.pop(); 
                }
                else {
                    return false; 
                }
            }
        }
        
        if (stk.size() == 0) {
            return true; 
        }
        
        return false; 
    }
}
