/**
 * Determine if the third string is the interleaving of another two strings. 
 * Solve it using dynamic programming. T[i][j] is true if the first ith char
 * in s1 and jth char in s2 are interleaving of the third string. If c1 == c3, 
 * then T[i][j] |= T[i - 1][j]; Also, if c2 == c3, then T[i][j] |= T[i][j - 1].
 */ 
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(); 
        int len2 = s2.length(); 
        int len3 = s3.length(); 
        
        if (len3 != (len1 + len2)) {
            return false; 
        }
        
        boolean[][] T = new boolean[len1 + 1][len2 + 1]; 
        T[0][0] = true; 
        
        for (int i = 1; i <= len1; i++) {
            int index = i - 1; 
            
            if (s1.charAt(index) != s3.charAt(index)) {
                T[i][0] = false; 
            } else {
                T[i][0] = T[i - 1][0]; 
            }
        }
        
        for (int j = 1; j <= len2; j++) {
            int index = j - 1; 
            
            if (s2.charAt(index) != s3.charAt(index)) {
                T[0][j] = false; 
            } else {
                T[0][j] = T[0][j - 1];
            }
        }
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                char c1 = s1.charAt(i - 1); 
                char c2 = s2.charAt(j - 1); 
                char c3 = s3.charAt(i + j - 1);
                
                if (c1 != c3 && c2 != c3) {
                    T[i][j] = false; 
                } else {
                    if (c1 == c3) {
                        T[i][j] |= T[i - 1][j]; 
                    }
                    
                    if (c2 == c3) {
                        T[i][j] |= T[i][j - 1]; 
                    }
                }
            }
        }
        
        return T[len1][len2]; 
    }
}
