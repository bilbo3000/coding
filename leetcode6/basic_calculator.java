/**
 * Implement a basic calculator that calculates equations containing +, -, (, ).
 * The idea was to first convert the equation from infix to post fix format using a stack to 
 * store operators an an output queue. For each operator op1, if top of stack op2 has higher or 
 * equal precedence, pop op2 to output queue and push op1, otherwise, push op1 directly. When 
 * sees a "(", push onto stack. When see a ")", pop stack to output queue until a "(". 
 * Once we have the postfix, we can evaluate it as reverse polish notation using a stack. 
 */ 
public class Solution {
    public int calculate(String s) {
                Stack<Character> stack = new Stack<>(); 
        Queue<Integer> queue = new LinkedList<>();  
        int i = 0; 
        
         while (i < s.length()) {
            char c = s.charAt(i);
            
            if (c == ' ') {
                i++; 
                continue; 
            } else if (c == '+' || c == '-') {
                // +: -1; -: -2; 
                if (!stack.isEmpty() && (stack.peek() == '+' || stack.peek() == '-')) {
                    char op = stack.pop(); 
                    
                    if (op == '+') {
                        queue.add(-1);
                    } else {
                        queue.add(-2);
                    }
                }
                    
                stack.push(c);
                i++; 
            } else if (c >= '0' && c <= '9') {
                int j = i + 1; 
                
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    j++; 
                }
                
                int val = Integer.parseInt(s.substring(i, j));
                queue.add(val);
                i = j; 
            } else if (c == '(') {
                stack.push(c);
                i++; 
            } else if (c == ')') {
                while (stack.size() != 0 && stack.peek() != '(') {
                    char op = stack.pop(); 
                    
                    if (op == '+') {
                        queue.add(-1);
                    } else {
                        queue.add(-2);
                    }
                }
                
                if (stack.size() != 0) {
                    stack.pop(); 
                }
                
                i++; 
            } else {
                i++; 
            }
        }
        
        while (stack.size() != 0) {
            char op = stack.pop(); 
                    
            if (op == '+') {
                queue.add(-1);
            } else {
                queue.add(-2);
            }
        }
        
        // Calculate the result 
        Stack<Integer> stack2 = new Stack<>(); 
        
        while (queue.size() != 0) {
            int val = queue.remove(); 
            
            if (val == -1) {
                // +
                int op2 = stack2.pop(); 
                int op1 = stack2.pop(); 
                stack2.push(op1 + op2);
            } else if (val == -2) {
                // -
                int op2 = stack2.pop(); 
                int op1 = stack2.pop(); 
                stack2.push(op1 - op2);
            } else {
                stack2.push(val);
            }
        }
        
        if (stack2.size() == 0) {
            return 0; 
        }
        
        return stack2.pop();
    }
}
