public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     * 
     * Dynamic programming. T[i][j]: the longest common subsequence with A[:i]
     * and B[:j]. 
     * O(mn) where m is length of A and n is length of B. 
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int len1 = A.length(); 
        int len2 = B.length(); 
        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        int[][] T = new int[len1][len2];
        
        for (int i = 0; i < len1; i++) {
            if (A.charAt(i) == B.charAt(0)) {
                T[i][0] = 1; 
            } else {
                if (i == 0) {
                    T[0][0] = 0; 
                } else {
                    T[i][0] = T[i - 1][0]; 
                }
            }
        }
        
        for (int j = 0; j < len2; j++) {
            if (A.charAt(0) == B.charAt(j)) {
                T[0][j] = 1;
            } else {
                if (j == 0) {
                    T[0][0] = 0; 
                } else {
                    T[0][j] = T[0][j - 1]; 
                }
            }
        }
        
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    T[i][j] = T[i - 1][j - 1] + 1; 
                    T[i][j] = Math.max(T[i][j], T[i][j - 1]);
                    T[i][j] = Math.max(T[i][j], T[i - 1][j]);
                } else {
                    T[i][j] = T[i - 1][j]; 
                    T[i][j] = Math.max(T[i][j], T[i][j - 1]);
                }
            }
        }
        
        return T[len1 - 1][len2 - 1];
    }
}

