/**
 * Calculate sqrt(x). 
 * Maintain a base. Each time double the base until when (result + base) ^ 2 > x, then 
 * reset the base to 1. 
 */ 
public class Solution {
    public int mySqrt(int x) {
        
        if (x == 0 || x == 1) {
            return x; 
        }
        
        long n = (long) x; 
        long result = 1;
        long base = 1;
        
        while ((result + base) * (result + base) <= n) {
             while ((result + base) * (result + base) <= n) {
                 result = result + base; 
                 base = base << 1; 
             }
             
             base = 1;
        }
        
        return (int) result; 
    }
}
