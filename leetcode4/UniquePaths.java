public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0; 
        }
        
        int[][] T = new int[m][n];  // T[i][j]: number of unique paths reach current cell 
       
        for (int i = 0; i < m; i++) {
            T[i][0] = 1; 
        }
        
        for (int i = 0; i < n; i++) {
            T[0][i] = 1; 
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                T[i][j] = T[i][j - 1] + T[i - 1][j]; 
            }
        }
        
        return T[m - 1][n - 1]; 
    }
}
