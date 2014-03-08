public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length; 
        
        if (m == 0) {
            return 0; 
        }
        
        int n = grid[0].length; 
        
        if (n == 0) {
            return 0; 
        }
        
        int[][] T = new int[m][n]; 
        T[0][0] = grid[0][0]; 
        
        for (int j = 1; j < n; j++) {
            T[0][j] = T[0][j - 1] + grid[0][j]; 
        }
        
        for (int i = 1; i < m; i++) {
            T[i][0] = T[i - 1][0] + grid[i][0]; 
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                T[i][j] = Math.min(T[i][j - 1], T[i - 1][j]) + grid[i][j]; 
            }
        }
        
        return T[m - 1][n - 1]; 
    }
}
