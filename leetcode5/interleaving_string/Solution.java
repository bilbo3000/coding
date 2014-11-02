public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(); 
        int len2 = s2.length(); 
        int len3 = s3.length(); 
        
        if (len1 + len2 != len3) {
            return false; 
        }
        
        boolean[][] T = new boolean[len1 + 1][len2 + 1]; 
        T[0][0] = true; 
        
        for (int i = 1; i <= len1; i++) {
            if (T[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1)) {
                T[i][0] = true; 
            }
        }
        
        for (int j = 1; j <= len2; j++) {
            if (T[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1)) {
                T[0][j] = true; 
            }
        }
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && T[i - 1][j] || 
                s2.charAt(j - 1) == s3.charAt(i + j - 1) && T[i][j - 1]) {
                    T[i][j] = true; 
                }
            }
        }
        
        return T[len1][len2]; 
    }
}
