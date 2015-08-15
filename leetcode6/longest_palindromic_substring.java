/**
 * Find the longest palindrome substring in the given string. 
 * Solve it using dynamic programming. T[i][j] is true if substring from index 
 * i to j is a palindrome. Whenever find a palindrome substring, compare and update 
 * the max, left index, and right index. 
 */ 
public class Solution {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray(); 
        int len = arr.length; 
        boolean[][] T = new boolean[len][len]; 
        int max = 1; 
        int left = 0; 
        int right = 0; 
        
        for (int i = 0; i < len; i++) {
            T[i][i] = true; 
        }
        
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                max = 2; 
                left = i; 
                right = i + 1; 
                T[i][i + 1] = true; 
            }
        }
        
        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                if (arr[i] == arr[j]) {
                    T[i][j] = T[i + 1][j - 1]; 
                    
                    if (T[i][j] && ((j - i + 1) > max)) {
                        left = i; 
                        right = j; 
                        max = j - i + 1; 
                    }
                }
            }
        } 
        
        return s.substring(left, right + 1); 
    }
}
