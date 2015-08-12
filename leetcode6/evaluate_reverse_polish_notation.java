/**
 * Evalute reverse polish notation. 
 * The idea was to use a stack. Looping through the input. If it is 
 * an operator, pop oprand2 and oprand1 from the stack, perform the 
 * operation and put the result back to the stack. If it is a number, 
 * simply put the value to the stack. In the end, the only value left 
 * in the stack would be the result to return. 
 */ 
public class Solution {
    public int evalRPN(String[] tokens) {
        int len = tokens.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        Stack<Integer> stack = new Stack<>(); 
        
        for (String str : tokens) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int op2 = stack.pop(); 
                int op1 = stack.pop(); 
                
                if (str.equals("+")) {
                    stack.push(op1 + op2); 
                } else if (str.equals("-")) {
                    stack.push(op1 - op2); 
                } else if (str.equals("*")) {
                    stack.push(op1 * op2); 
                } else {
                    stack.push(op1 / op2); 
                }
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        
        return stack.pop();
    }
}
