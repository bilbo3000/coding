public class Solution {
    public int atoi(String str) {
        long result = 0; 
        int i = 0; 
        int len = str.length(); 
        
        while (i < len) {
            if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != '-' && str.charAt(i) != '+' && str.charAt(i) != ' ') {
                return 0; 
            }
            
            if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                break; 
            }
            
            if (Character.isDigit(str.charAt(i))) {
                break; 
            }
            
            i++; 
        }
        
        if (i == len) {
            return (int) result; 
        }
        
        boolean isNeg = false; 
        
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            if (str.charAt(i) == '-') {
                isNeg = true; 
            }
            
            i++; 
        }
        
        while (i < len && Character.isDigit(str.charAt(i))) {
            long digit = (long) (str.charAt(i) - '0'); 
            result = result * 10 + digit; 
            i++; 
        }
        
        if (isNeg) {
            if ((-result) < (long) Integer.MIN_VALUE) {
                return Integer.MIN_VALUE; 
            }
            
            return (int) (-result); 
        }
        
        if (result > (long) Integer.MAX_VALUE) {
            return Integer.MAX_VALUE; 
        }
        
        return (int) result; 
    }
}
