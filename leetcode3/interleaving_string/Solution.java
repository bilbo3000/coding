public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(); 
        int n = s2.length(); 
        int k = s3.length(); 
        
        if (m + n != k) {
            return false; 
        }
        
        boolean[][] T = new boolean[m + 1][n + 1]; 
        T[0][0] = true; 
        
        for (int j = 1; j <= n; j++) {
            T[0][j] = T[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1)); 
        }
        
        for (int i = 1; i <= m; i++) {
            T[i][0] = T[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));  
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                T[i][j] = (T[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1))) || (T[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1))); 
            }
        }
        
        return T[m][n]; 
    }
}
