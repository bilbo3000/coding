/*
Determine if given string contains valid parentheses. 

Use a stack to store left paren. Whenever TOS matches a current right parent, 
pop from the stack. 

Return false when there's a mismatch or stack is not empty in the end. 

Time: O(n), walk through entire array. 
Space: O(n), worst case all characters are left parens and stored in the stack. 
*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); 
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty() && 
                       ((c == ')' && stack.peek() == '(') 
                        || (c == ']' && stack.peek() == '[') 
                        || (c == '}' && stack.peek() == '{'))){
                stack.pop();
            } else {
                return false; 
            }
        }
        
        if (stack.isEmpty()) {
            return true; 
        }
        
        return false; 
    }
}
