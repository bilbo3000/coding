public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>(); 
        
        for (String item : tokens) {
            if (item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/")) {
                int op2 = s.pop(); 
                int op1 = s.pop(); 
                
                if (item.equals("+")) {
                    s.push(op1 + op2); 
                } else if (item.equals("-")) {
                    s.push(op1 - op2); 
                } else if (item.equals("*")) {
                    s.push(op1 * op2); 
                } else if (item.equals("/")) {
                    s.push(op1 / op2); 
                }
            } else {
                int num = Integer.parseInt(item);
                s.push(num); 
            }
        }
        
        if (s.size() != 0) {
            return s.pop(); 
        } else {
            return 0; 
        }
    }
}
