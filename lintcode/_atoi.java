public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        long res = 0; 
        int len = str.length(); 
        int i = 0; 
        
        while (i < len && !(Character.isDigit(str.charAt(i)) || str.charAt(i) == '-' || str.charAt(i) == '+')) {
            i++; 
        }
        
        boolean isNeg = false; 
        
        if (i < len && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            if (str.charAt(i) == '-') {
                isNeg = true; 
            }
            
            i++; 
        }
        
        while (i < len && Character.isDigit(str.charAt(i))) {
            long d = (long) (str.charAt(i) - '0'); 
            res = res * 10 + d; 
            
            long temp = res; 
            
            if (isNeg) {
                temp = -temp; 
            }
            
            if (!isNeg && (temp >= (long) Integer.MAX_VALUE)) {
                return Integer.MAX_VALUE; 
            }
            
            if (isNeg && (temp <= (long) Integer.MIN_VALUE)) {
                return Integer.MIN_VALUE; 
            }
            
            i++; 
        }
        
        if (isNeg) {
            res = -res; 
        }

        
        if (!isNeg && (res >= (long) Integer.MAX_VALUE)) {
            return Integer.MAX_VALUE; 
        }
        
        if (isNeg && (res <= (long) Integer.MIN_VALUE)) {
            return Integer.MIN_VALUE; 
        }
        
        return (int) res; 
    }
}
