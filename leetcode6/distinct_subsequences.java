/**
 * Find the number of distinct subsequences of t in s. 
 * Solve it using dynamic programming. T[i][j] means number of subsequences of 
 * t[:j] in s[:i]. For current letter in t, if it is the same as the current 
 * letter in s, then it has two options, either to match or not to match. Thus, 
 * the value for current cell in T would be the sum of the two. 
 */ 
public class Solution {
    public int numDistinct(String s, String t) {
        int len1 = s.length(); 
        int len2 = t.length(); 
        
        if (len1 < len2) {
            return 0; 
        }
        
        if (s.equals(t)) {
            return 1; 
        }
        
        char[] arr1 = s.toCharArray(); 
        char[] arr2 = t.toCharArray(); 
        
        int[][] T = new int[len1][len2]; 
        
        if (arr1[0] == arr2[0]) {
            T[0][0] = 1; 
        } else {
            T[0][0] = 0; 
        }
        
        for (int i = 1; i < len1; i++) {
            if (arr1[i] == arr2[0]) {
                T[i][0] = T[i - 1][0] + 1; 
            } else {
                T[i][0] = T[i - 1][0]; 
            }
        }
        
        for (int j = 1; j < len2; j++) {
            T[0][j] = 0;  
        }
        
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (arr1[i] == arr2[j]) {
                    T[i][j] = T[i - 1][j] + T[i - 1][j - 1]; 
                } else {
                    T[i][j] = T[i - 1][j]; 
                }
            }
        }
        
        return T[len1 - 1][len2 - 1]; 
    }
}
