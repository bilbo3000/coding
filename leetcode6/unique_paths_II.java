/**
 * Find unique number of ways travel from upper left corner to 
 * lower right corner within a grid with obstacles. 
 * Use dynamic programming. The number of ways to get to current 
 * point is the sum of that for the up and left points. 
 */ 
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length; 
        
        if (m == 0) {
            return 0; 
        }
        
        int n = obstacleGrid[0].length; 
        
        if (n == 0) {
            return 0; 
        }
        
        int[][] T = new int[m][n]; 
        
        if (obstacleGrid[0][0] == 0) {
            T[0][0] = 1; 
        } else {
            T[0][0] = 0; 
        }
        
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                T[i][0] = 0; 
            } else {
                T[i][0] = T[i - 1][0]; 
            }
        }
        
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                T[0][j] = 0; 
            } else {
                T[0][j] = T[0][j - 1]; 
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    T[i][j] = 0;
                } else {
                    T[i][j] = T[i - 1][j] + T[i][j - 1]; 
                }
            }
        }
        
        return T[m - 1][n - 1]; 
    }
}
