/**
 * Reverse an integer. 
 * A couple of things need to pay attention. First, consider the case where 
 * the integer is negative. Then consider the case where after reverse it, 
 * the resulting number may overflow. The solution was to convert the input 
 * to long and also keep track whether it is negative or not. Comparing the 
 * result to (int) Integer.MAX_VALUE or (int) Integer.MIN_VALUE to see if 
 * there is any overflow. 
 */
public class Solution {
    public int reverse(int x) {
        long n = (long) x; 
        boolean isNeg = false; 
        
        if (x < 0) {
            isNeg = true; 
            n = -1 * n; 
        }
        
        long result = 0; 
        
        while (n > 0) {
            long digit = n % 10; 
            n = n / 10; 
            result = result * 10 + digit; 
        }
        
        if (isNeg) {
            result = -1 * result; 
        }
        
        if ((!isNeg && result > (long) Integer.MAX_VALUE) || (isNeg && result < (long) Integer.MIN_VALUE)) {
            return 0; 
        }
        
        return (int) result; 
    }
}
