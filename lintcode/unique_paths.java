public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     * 
     * O(mn)
     */
    public int uniquePaths(int m, int n) {
        int[][] T = new int[m][n]; 
        
        for (int i = 0; i < m; i++) {
            T[i][0] = 1; 
        }
        
        for (int j = 0; j < n; j++) {
            T[0][j] = 1; 
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                T[i][j] = T[i - 1][j] + T[i][j - 1]; 
            }
        }
        
        return T[m - 1][n - 1]; 
    }
}

