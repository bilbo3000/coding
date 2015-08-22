/**
 * Find the minimum cuts to splint a given string such that each part is a palindrome. 
 * Use dynamic programming. First build palindrome table T[i][j] indicates s[i:j] is a 
 * palindrome. Then build array T[i] meaning the minimum number of split in s[:i]. 
 * For each T[i], loop though previous T and find the minimum value. 
 */ 
public class Solution {
    public int minCut(String s) {
        int len = s.length(); 
        
        if (len == 0) {
            return 0; 
        }
        
        char[] arr = s.toCharArray(); 
        boolean[][] T = new boolean[len][len]; 
        
        for (int i = 0; i < len; i++) {
            T[i][i] = true; 
        }
        
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                T[i][i + 1] = true; 
            } else {
                T[i][i + 1] = false; 
            }
        }
        
        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                if (arr[i] != arr[j]) {
                    T[i][j] = false; 
                } else {
                    T[i][j] = T[i + 1][j - 1]; 
                }
            }
        }
        
        int[] res = new int[len];
        
        for (int i = 0; i < len; i++) {
            res[i] = i; 
        }
        
        for (int i = 1; i < len; i++) {
            if (T[0][i]) {
                res[i] = 0; 
            } else {
                int j = i; 
                
                while (j > 0) {
                    if (T[j][i]) {
                        res[i] = Math.min(res[i], res[j - 1] + 1);
                    }
                    
                    j--; 
                }
            }
        }
        
        return res[len - 1];
    }
}
