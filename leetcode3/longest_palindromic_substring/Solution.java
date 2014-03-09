public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length(); 
        boolean[][] T = new boolean[len][len];
        
        for (int i = 0; i < len; i++) {
            T[i][i] = true; 
        }
        
        for (int i = 1; i < len; i++) {
            T[i - 1][i] = s.charAt(i - 1) == s.charAt(i) ? true : false; 
        }
        
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    T[i][j] = false; 
                }
                else {
                    T[i][j] = T[i + 1][j - 1]; 
                }
            }
        }
        
        int max = 0; 
        String maxString = ""; 
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (T[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1; 
                        maxString = s.substring(i, j + 1); 
                    } 
                }
            }
        }
        
        return maxString; 
    }
    
}
