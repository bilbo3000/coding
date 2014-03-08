public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();

        for (String item : tokens) {
            if (item.equals("+")) {
                int op2 = s.pop();
                int op1 = s.pop();
                s.push(op1 + op2);
            }
            else if (item.equals("-")) {
                int op2 = s.pop();
                int op1 = s.pop();
                s.push(op1 - op2);
            }
            else if (item.equals("*")) {
                int op2 = s.pop();
                int op1 = s.pop();
                s.push(op1 * op2);
            }
            else if (item.equals("/")) {
                int op2 = s.pop();
                int op1 = s.pop();
                s.push(op1 / op2);
            }
            else {
                s.push(Integer.parseInt(item));
            }
        }

        return s.pop();
    }
}
