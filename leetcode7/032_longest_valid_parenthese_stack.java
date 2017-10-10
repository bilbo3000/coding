/*
Find the longest valid parenthese. 

Stack approach: 
Use a stack to store indices; stack initialize to -1 --> the initial left boundary;
1) if encounter a (, push its index onto the stack; 
2) if encounter a ), pop stack
2.1) if stack is not empty, must popped a (, --> current length is i - stack.peek()
Note, stack.peek() could be left boundary or index of a (; 
2.2) if stack is empty, must popped a left boundary --> ) doesn't match a (
--> ) is extra --> ) becomes the left boundary; 

Time: O(n)
Space: O(n)
*/
class Solution {
    public int longestValidParentheses(String s) {
        int max = 0; 
        if (s == null || s.length() == 0) {
            return max; 
        }
        int len = s.length(); 
        Stack<Integer> stack = new Stack<Integer>(); 
        stack.push(-1);
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop(); 
                
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        
        return max; 
    }
}
