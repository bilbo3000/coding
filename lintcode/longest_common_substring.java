public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     * 
     * Longest common *substring*. 
     * T[i][j]: longest common substring ending with A[i] and B[j]. 
     * T[i][j] = T[i - 1][j - 1] if A[i] == B[j]; otherwise, 0.
     * O(mn).
     */
    public int longestCommonSubstring(String A, String B) {
        int m = A.length(); 
        int n = B.length(); 
        
        if (m == 0 || n == 0) {
            return 0; 
        }
        
        int[][] T = new int[m][n]; 
        int max = 0; 
        
        for (int i = 0; i < m; i++) {
            if (A.charAt(i) == B.charAt(0)) {
                T[i][0] = 1; 
                max = 1; 
            }
        }
        
        for (int j = 0; j < n; j++) {
            if (A.charAt(0) == B.charAt(j)) {
                T[0][j] = 1; 
                max = 1; 
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    T[i][j] = T[i - 1][j - 1] + 1; 
                    max = Math.max(max, T[i][j]);
                } else {
                    T[i][j] = 0; 
                }
            }
        }
        
        return max; 
    }
}
