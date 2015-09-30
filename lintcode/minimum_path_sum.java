public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     * 
     * O(mn)
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length; 
        int[][] T = new int [m][n]; 
        T[0][0] = grid[0][0]; 
        
        for (int i = 1; i < m; i++) {
            T[i][0] = grid[i][0] + T[i - 1][0]; 
        }
        
        for (int j = 1; j < n; j++) {
            T[0][j] = grid[0][j] + T[0][j - 1]; 
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                T[i][j] = Math.min(T[i - 1][j], T[i][j - 1]) + grid[i][j];
            }
        }
        
        return T[m - 1][n - 1]; 
    }
}

