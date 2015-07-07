/**
 * Count the number of 1s in the binary representation of the given number. 
 * 
 * The first solution is most intuitive. Just keep shifting the number to right. 
 * Each time increment the count if the last bit is 1 (which can be checked via 
 * modulo 2). However, this approach times out. 
 * 
 * The second solution is tricky. The idea was to remove the rightmost 1 each 
 * time and meanwhile, count the number of times we removed the 1s until the 
 * number become zero. Operation n & (n - 1)
 * will remove the rightmost 1. It is because when you minus 1, all the trailing 
 * zeros will turn to 1s and the right most 1 will turn to 0. Then do you the &, 
 * and it will clear all those bits to 0. 
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0; 
        
        while (n != 0) {
            n = n & (n - 1); 
            result++; 
        }
        
        return result; 
    }
}
