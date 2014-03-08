public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(); 
        int len2 = s2.length(); 
        int len3 = s3.length(); 
        
        if (len1 + len2 != len3) return false; 
        
        boolean[][] T = new boolean[len1 + 1][len2 + 1]; 
        
        // Initialization 
        for (int i = 0; i < len1 + 1; i++) {
            for (int j = 0; j < len2 + 1; j++) {
                T[i][j] = false; 
            }
        }
        
        T[0][0] = true; 
        
        // Initialize first row
        for (int j = 1; j < len2 + 1; j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                T[0][j] = T[0][j - 1];  
            }
            else {
                T[0][j] = false; 
            }
        }
        
        // Initialize first column
        for (int i = 1; i < len1 + 1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                T[i][0] = T[i - 1][0]; 
            }
            else {
                T[i][0] = false; 
            }
        }
        
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    T[i][j] |= T[i - 1][j]; 
                }
                
                if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    T[i][j] |= T[i][j - 1]; 
                }
            }
        }
        
        return T[len1][len2]; 
    }
}
