/**
 * Implement a basic calculator that calculates equations containing +, -, *, /.
 * The idea was to first convert the equation from infix to post fix format using a stack to 
 * store operators an an output queue. For each operator op1, pop ALL top of op1 from stack that 
 * has higher or equal precendence.
 * Once we have the postfix, we can evaluate it as reverse polish notation using a stack. 
 */
public class Solution {
    public int calculate(String s) {
        Map<Character, Integer> m = new HashMap<>(); 
        m.put('+', -1);
        m.put('-', -2);
        m.put('*', -3);
        m.put('/', -4);
        Map<Character, Integer> pre = new HashMap<>(); 
        pre.put('+', 0);
        pre.put('-', 0);
        pre.put('*', 1);
        pre.put('/', 1);
        
        Stack<Character> stack = new Stack<>(); 
        Queue<Integer> queue = new LinkedList<>(); 
        int i = 0; 
        
        while (i < s.length()) {
            char c = s.charAt(i);
            
            if (c == ' ') {
                i++; 
                continue; 
            } else if (c >= '0' && c <= '9') {
                int j = i + 1; 
                
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    j++; 
                }
                
                int val = Integer.parseInt(s.substring(i, j));
                queue.add(val);
                i = j; 
            } else {
                while (!stack.isEmpty() && pre.get(stack.peek()) >= pre.get(c)) {
                    queue.add(m.get(stack.pop()));
                }
                
                stack.push(c);
                i++; 
            }
        }
        
        while (!stack.isEmpty()) {
            queue.add(m.get(stack.pop()));
        }
        
        // Evaluate 
        Stack<Integer> stack2 = new Stack<>(); 
        
        while (!queue.isEmpty()) {
            int val = queue.remove(); 
            
            if (val < 0) {
                int op2 = stack2.pop(); 
                int op1 = stack2.pop(); 
                
                if (val == -1) {
                    stack2.push(op1 + op2);
                } else if (val == -2) {
                    stack2.push(op1 - op2);
                } else if (val == -3) {
                    stack2.push(op1 * op2);
                } else {
                    stack2.push(op1 / op2);
                }
            } else {
                stack2.push(val);
            }
        }
        
        if (stack2.isEmpty()) {
            return 0; 
        }
        
        return stack2.pop(); 
    }
}
