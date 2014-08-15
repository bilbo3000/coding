public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(); 
        int len2 = s2.length(); 
        int len3 = s3.length(); 
        
        if (len1 + len2 != len3) {
            return false; 
        }
        
        if (len1 == 0 && s2.equals(s3)) {
            return true; 
        }
        
        if (len2 == 0 && s1.equals(s3)) {
            return true; 
        }
        
        boolean[][] T = new boolean[len1 + 1][len2 + 1];  // T[i][j] whether first i letter in s1 and first j letter in s2 is interleaving of first i + j letter in s3
        T[0][0] = true; 
        for (int i = 1; i <= len1; i++) {
            if (s1.substring(0, i).equals(s3.substring(0, i))) {
                T[i][0] = true; 
            }
        }
        
        for (int j = 1; j <= len2; j++) {
            if (s2.substring(0, j).equals(s3.substring(0, j))) {
                T[0][j] = true; 
            }
        }
        
        for (int i = 1; i < len1 + 1; i++) {
            for (int j  = 1; j < len2 + 1; j++) {
                T[i][j] = (T[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (T[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)); 
            }
        }
        
        return T[len1][len2]; 
    }
}
