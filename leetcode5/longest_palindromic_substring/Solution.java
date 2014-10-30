public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length(); 
        
        if (len == 0) {
            return s; 
        }
        
        int l = 0; 
        int r = 0; 
        int max = 1; 
        
        boolean[][] T = new boolean[len][len]; 
        
        for (int i = 0; i < len; i++) {
            T[i][i] = true; 
        }
        
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                T[i][i + 1] = true; 
                l = i; 
                r = i + 1; 
                max = 2; 
            } else {
                T[i][i + 1] = false; 
            }
        }
        
        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && T[i + 1][j - 1]) {
                    T[i][j] = true; 
                    
                    if (j - i + 1 > max) {
                        max = j - i + 1; 
                        l = i; 
                        r = j; 
                    }
                } else {
                    T[i][j] = false; 
                }
            }
        }
        
        return s.substring(l, r + 1); 
    }
}
