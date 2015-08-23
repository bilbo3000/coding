/**
 * Determine whether two given strings are scramble strings. 
 * boolean T[i][j][len] means whether s1 end at i and s2 end at j with length len + 1
 * are scramble strings. For each iterator, need to split at every position forward and 
 * backward to determine if they are scramble. 
 */ 
public class Solution {
    public boolean isScramble(String s1, String s2) {
        int len1 = s1.length(); 
        int len2 = s2.length(); 
        
        if (len1 != len2) {
            return false; 
        }
        
        if (s1.equals(s2)) {
            return true; 
        }
        
        int len = len1; 
        char[] arr1 = s1.toCharArray(); 
        char[] arr2 = s2.toCharArray(); 
        
        boolean[][][] T = new boolean[len][len][len + 1]; 
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (arr1[i] == arr2[j]) {
                    T[i][j][1] = true; 
                }
            }
        }
        
        for (int k = 2; k <= len; k++) {
            for (int i = k - 1; i < len; i++) {
                for (int j = k - 1; j < len; j++) {
                    for (int x = 1; x < k; x++) {
                        if (T[i][j][x] && T[i - x][j - x][k - x] || T[i][j - k + x][x] && T[i - x][j][k - x]) {
                            T[i][j][k] = true; 
                        }
                    }
                }
            }
        }
        
        return T[len1 - 1][len2 - 1][len];
    }
}
