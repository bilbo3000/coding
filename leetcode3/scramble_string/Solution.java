public class Solution {
    public boolean isScramble(String s1, String s2) {
        int len1 = s1.length(); 
        int len2 = s2.length(); 
        
        if (len1 != len2) {
            return false; 
        }
        
        int len = len1; 
        
        boolean [][][] T = new boolean[len][len][len + 1]; 
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                T[i][j][1] = s1.charAt(i) == s2.charAt(j) ? true : false; 
            }
        }
        
        for (int k = 2; k <= len; k++) {
            for (int i = k - 1; i < len; i++) {
                for (int j = k - 1; j < len; j++) {
                    boolean result = false; 
                    
                    for (int x = 1; x < k; x++) {
                        result |= T[i][j][x] && T[i - x][j - x][k - x];
                        result |= T[i][j - k + x][x] && T[i - x][j][k - x]; 
                    }
                    
                    T[i][j][k] = result; 
                }
            }
        }
        
        
        return T[len - 1][len - 1][len]; 
    }
}
