public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>(); 

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") && s.size() >= 2) {
                int op2 = s.pop(); 
                int op1 = s.pop(); 
                s.push(op1 + op2); 
            } else if (tokens[i].equals("-") && s.size() >= 2) {
                int op2 = s.pop(); 
                int op1 = s.pop(); 
                s.push(op1 - op2); 
            } else if (tokens[i].equals("*") && s.size() >= 2) {
                int op2 = s.pop(); 
                int op1 = s.pop(); 
                s.push(op1 * op2); 
            } else if (tokens[i].equals("/") && s.size() >= 2) {
                int op2 = s.pop(); 
                int op1 = s.pop(); 
                s.push(op1 / op2); 
            } else {
                s.push(Integer.parseInt(tokens[i])); 
            }
        }
        
        if (s.size() != 0) {
            return s.pop(); 
        }
        
        return 0; 
    }
}
