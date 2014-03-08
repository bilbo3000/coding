public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length(); 
        int max = 0; 
        int l = 0; 
        int r = 0; 
        boolean[][] T = new boolean[len][len]; 
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                T[i][j] = false; 
            }
        }
        
        for (int i = 0; i < len; i++) {
            T[i][i] = true; 
            max = 1; 
            l = i; 
            r = i; 
        }
        
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                T[i - 1][i] = true; 
                max = 2; 
                l = i - 1; 
                r = i; 
            }
        }
        
        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                T[i][j] = (s.charAt(i) == s.charAt(j)) && T[i + 1][j - 1]; 
                
                if (T[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1; 
                        l = i; 
                        r = j; 
                    }
                }
            }
        }
        
        return s.substring(l, r + 1); 
    }
}
