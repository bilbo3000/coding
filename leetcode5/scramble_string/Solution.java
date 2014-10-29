public class Solution {
    public boolean isScramble(String s1, String s2) {
        int len = s1.length(); 
        
        if (len == 0) {
            return true; 
        }
        
        boolean[][][] T = new boolean[len][len][len + 1];
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    T[i][j][1] = true; 
                } else {
                    T[i][j][1] = false; 
                }
            }
        }
        
        for (int k = 2; k <= len; k++) {
            for (int i = 0; i <= len - k; i++) {
                for (int j = 0; j <= len - k; j++) {
                    for (int x = 1; x < k; x++) {
                        if (T[i][j][x] && T[i + x][j + x][k - x]) {
                            T[i][j][k] = true; 
                            break; 
                        }
                        
                        if (T[i][j + k - x][x] && T[i + x][j][k - x]) {
                            T[i][j][k] = true; 
                            break; 
                        }
                    }
                }
            }
        }
        
        return T[0][0][len]; 
    }
}
