/**
 * Check if a given number is power of two. 
 * The idea was to keep devide the number by 2 until the number becomes 1. 
 * Within the loop, if the number modulo 2 is ever not zero, then it must 
 * not be power of 2. If the number eventually becomes 1, then it is power
 * two. Note that negative number must not be power of two. Also, make sure 
 * to convert the input to long before processing. 
 */ 
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false; 
        }
        
        long x = n; 
        
        if (x < 0) {
            return false; 
        }
        
        while (x != 1) {
            if (x % 2 == 1) {
                return false; 
            } 
            
            x = x / 2; 
        }
        
        return true; 
    }
}
