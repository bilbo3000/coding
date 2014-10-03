public class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<Character>(); 
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            if (c == ')' || c == '}' || c == ']') {
                if (s.size() == 0) {
                    return false; 
                }
                else {
                    if ((c == ')' && s.peek() != '(') || (c == '}' && s.peek() != '{') || (c == ']' && s.peek() != '[')) {
                        return false; 
                    } else {
                        s.pop(); 
                    }
                }
            } else {
                s.push(c);
            }
        }
        
        if (s.size() == 0) {
            return true; 
        } else {
            return false; 
        }
    }
}
