public class Solution {
    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>(); 
        
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // Operator 
                int op2 = stack.pop(); 
                int op1 = stack.pop(); 
                
                if (token.equals("+")) {
                    stack.push(op1 + op2);
                } else if (token.equals("-")) {
                    stack.push(op1 - op2);
                } else if (token.equals("*")) {
                    stack.push(op1 * op2);
                } else {
                    stack.push(op1 / op2);
                }
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        
        return stack.pop();
    }
}
