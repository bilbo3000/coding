/**
 * Find the number of ways of adding parentheses to an equation. 
 * Solve it recursively. For each operator, split the string in halves and recursively 
 * process each half. The base case is that the string does not contain any operator. 
 * i.e. !input.contains("+"). Also pair each returned results from left and right children. 
 */ 
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>(); 
        
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            result.add(Integer.parseInt(input));
            return result; 
        }
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i)); 
                List<Integer> right = diffWaysToCompute(input.substring(i + 1)); 
                
                for (int op1 : left) {
                    for (int op2 : right) {
                        if (c == '+') {
                            result.add(op1 + op2);
                        } else if (c == '-') {
                            result.add(op1 - op2);
                        } else if (c == '*') {
                            result.add(op1 * op2);
                        }
                    }
                }
            }
        }
        
        return result;  
    }
}
