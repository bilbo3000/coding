public class Solution {
    public int atoi(String str) {
        int len = str.length(); 
        long result = 0; 

        int i = 0; 
        
        // Ignore leading spaces
        while (i < len && str.charAt(i) == ' ') {   
            i++; 
        }
        
        // Process signs, if any
        boolean isNeg = false; 
        
        if (i < len && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            if (str.charAt(i) == '-') {
                isNeg = true; 
            }
            
            i++; 
        }
        
        while (i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            long digit = (long) (str.charAt(i) - '0'); 
            result = result * 10 + digit; 
            i++; 
        }
        
        if (isNeg) {  // Negative 
            result = -result; 
            
            if (result <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            
            return (int) result; 
        }
        
        if (result >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE; 
        }
        
        return (int) result; 
    }
}
