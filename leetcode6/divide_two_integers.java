/**
 * Divide two integers. 
 * First convert both dividend and divisor to long type. Then determine whether the result 
 * would be negative. Maintain a base and count, each time double the base and double the count, 
 * till the base becomes larger than the remaining dividend. Then reset the base back to 
 * divisor and count to 1. Accumulate the count each time. 
 */ 
public class Solution {
    public int divide(int dividend, int divisor) {
        long a = (long) (dividend); 
        long b = (long) (divisor);
        
        boolean isNeg = false; 
        
        if (a < 0 && b > 0 || a > 0 && b < 0) {
            isNeg = true; 
        }
        
        if (a < 0) {
            a = -a; 
        }
        
        if (b < 0) {
            b = -b; 
        }
        
        long result = 0; 
        
        while (a >= b) {
            long base = b; 
            long count = 1; 
            
            while (a >= base) {
                a -= base; 
                result += count; 
                base = base << 1; 
                count = count << 1;
            }
        }
        
        if (isNeg) {
            result = -result; 
        }
        
        if (isNeg && result < (long) Integer.MIN_VALUE) {
            return Integer.MIN_VALUE; 
        }
        
        if (!isNeg && result > (long) Integer.MAX_VALUE) {
            return Integer.MAX_VALUE; 
        }
        
        return (int) result; 
    }
}
