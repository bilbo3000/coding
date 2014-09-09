public class Solution {
    public boolean isScramble(String s1, String s2) {
        int len1 = s1.length(); 
        int len2 = s2.length(); 
        
        if (len1 != len2) {
            return false; 
        }
        
        if (len1 == 0) {
            return true; 
        }
        
        boolean[][][] T = new boolean[len1][len1][len1 + 1]; 
        
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len1; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    T[i][j][1] = true; 
                } else {
                    T[i][j][1] = false; 
                }
            }
        }
        for (int k = 2; k <= len1; k++) {
            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len1; j++) {
                    if (i + k <= len1 && j + k <= len1) {
                        for (int x = 1; x < k; x++) {
                            T[i][j][k] |= T[i][j][x] && T[i + x][j + x][k - x];
                            T[i][j][k] |= T[i][j + k - x][x] && T[i + x][j][k - x]; 
                            
                            if (T[i][j][k]) {
                                break; 
                            }
                        }
                    }
                }
            }
        } 
        
        return T[0][0][len1]; 
    }
}
