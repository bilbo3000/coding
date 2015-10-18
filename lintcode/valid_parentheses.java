public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     * 
     * O(n).
     */
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>(); 
        char[] arr = s.toCharArray(); 
        
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i]; 
            
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false; 
                }
                
                char top = stack.pop(); 
                
                if ((c == ']' && top != '[') || (c == ')' && top != '(') || (c == '}' && top != '{')) {
                    return false; 
                }
            }
        }
        
        if (!stack.isEmpty()) {
            return false; 
        }
        
        return true; 
    }
}
