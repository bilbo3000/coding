/**
 * Implement atoi. 
 * Use double as the result type. Then convert to int before return. The reason to use double 
 * is the it can be calculated with int type. 
 */ 
public class Solution {
    public int myAtoi(String str) {
        double result = 0; 
        int i = 0; 
        int len = str.length(); 
        
        while (i < len && str.charAt(i) == ' ') {
            // Ignore all leading white spaces 
            i++; 
        }
        
        boolean isNeg = false; 
        
        if (i < len && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            if (str.charAt(i) == '-') {
                isNeg = true; 
            }
            
            i++; 
        }
        
        if (i >= len || !(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
            return 0; 
        }
        
        while (i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0'); 
            i++; 
        }
        
        if (isNeg) {
            result = -result; 
        }
        
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE; 
        }
        
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE; 
        } 
        
        return (int) result;
    }
}
