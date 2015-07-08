/**
 * Convert excel column to its corresponding number.
 * 
 * Comparing to 10 based number system, think this as 26 based number system. 
 * For example, in 10 based, 99 = 9 * 10^1 + 9 * 10^0. Thus, in 26 based, 
 * AB = 1 * 26^1 + 2 * 26^0. Loop though the input string character by character
 * and accumulate the result from each position would solve this problem.
 */
public class Solution {
    public int titleToNumber(String s) {
        int result = 0; 
        int len = s.length(); 
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i); 
            int num = (int)(c - 'A') + 1; 
            result += num * Math.pow(26, len - i - 1);
        }
        
        return result; 
    }
}
