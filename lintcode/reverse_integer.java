public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     *
     * Convert input to long type before processing. 
     */
    public int reverseInteger(int n) {
        long x = (long) n;
        long result = 0; 
        boolean isNeg = false; 
        
        if (n < 0) {
            isNeg = true; 
            x = -x; 
        }
        
        while (x > 0) {
            long d = x % 10; 
            x = x / 10; 
            result = result * 10 + d; 
        }
        
        if (isNeg) {
            result = -result; 
        }
        
        if (result > 0 && result > (long) Integer.MAX_VALUE) {
            return 0; 
        }
        
        if (result < 0 && result < (long) Integer.MIN_VALUE) {
            return 0; 
        }
        
        return (int) result; 
    }
}
