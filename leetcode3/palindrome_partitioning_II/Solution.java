public class Solution {
    public int minCut(String s) {
        int len = s.length(); 
        
        if (len == 0) {
            return 0; 
        }
        
        boolean[][] palin = new boolean[len][len];
        
        for (int i = 0; i < len; i++) {
            palin[i][i] = true; 
        }
        
        for (int i = 1; i < len; i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                palin[i - 1][i] = true; 
            }
            else {
                palin[i - 1][i] = false; 
            }
        }
        
        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    palin[i][j] = palin[i + 1][j - 1]; 
                }
                else {
                    palin[i][j] = false; 
                }
            }
        }
        
        int[] T = new int[len + 1]; 
        T[0] = -1; 
        
        for (int j = 1; j <= len; j++) {
            T[j] = Integer.MAX_VALUE;
            
            for (int i = j - 1; i >= 0; i--) {
                if (palin[i][j - 1]) {
                    T[j] = Math.min(T[j], T[i] + 1); 
                }
            }
        }
        
        return T[len]; 
    }
}
