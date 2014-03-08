public class Solution {
    public int evalRPN(String[] tokens) {
        int result = 0; 
        Stack<Integer> s = new Stack<Integer>(); 
        
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int op2 = s.pop(); 
                int op1 = s.pop(); 
                
                if (tokens[i].equals("+")) {
                    s.push(op1 + op2); 
                }
                else if (tokens[i].equals("-")) {
                    s.push(op1 - op2); 
                }
                else if (tokens[i].equals("*")) {
                    s.push(op1 * op2); 
                }
                else {
                    s.push(op1 / op2); 
                }
            }
            else {
                int n = Integer.parseInt(tokens[i]);
                s.push(n); 
            }
        }
        
        if (!s.empty()) result = s.pop(); 
        
        return result; 
    }
}
