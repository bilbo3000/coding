/**
 * Find the number of ways to decode a string of numbers to its alphabet. 
 * Solve it using dynamic programming. T[i] means the number of ways to 
 * decode prefix upto s[i]. Need to consider different cases including 
 * 0, <= 6, prev char is 1, 2. 
 */ 
public class Solution {
    public int numDecodings(String s) {
        int len = s.length(); 
        
        if (len == 0) {
            return 0; 
        }
        
        int[] T = new int[len]; 
        if (s.charAt(0) == '0') {
            T[0] = 0; 
        } else {
            T[0] = 1; 
        }

        for (int i = 1; i < len; i++) {
            int digit = (int) (s.charAt(i) - '0');
            int prev = (int) (s.charAt(i - 1) - '0');
            
            if (digit == 0) {
                if (prev == 1 || prev == 2) {
                    if (i >= 2) {
                        T[i] = T[i - 2]; 
                    } else {
                        T[i] = 1; 
                    }
                }
            } else if (digit <= 6) {
                T[i] = T[i - 1]; 
                
                if (prev == 1 || prev == 2) {
                    if (i >= 2) {
                        T[i] += T[i - 2]; 
                    } else {
                        T[i] += 1; 
                    }
                }
            } else if (prev == 1) {
                T[i] = T[i - 1]; 
                
                if (i >= 2) {
                    T[i] += T[i - 2]; 
                } else {
                    T[i] += 1; 
                }
            } else {
                T[i] = T[i - 1]; 
            }
        }
        
        return T[len - 1]; 
    }
}
