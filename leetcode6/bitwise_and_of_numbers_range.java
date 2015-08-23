/**
 * Bitwise AND a range of numbers. 
 * The observation is that the result of AND of a range number is the left common 
 * part of all the number, which is also the left common part of start and end numbers. 
 * Thus, we can keep shift both end to right one position at a time until they are the 
 * same. Meanwhile count the number of shifts. Then shift m back count number of times
 * to get the result. 
 */ 
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int cnt = 0; 
        
        while (m != n) {
            m = m >>> 1; 
            n = n >>> 1; 
            cnt++; 
        }
        
        return m << cnt; 
    }
}
