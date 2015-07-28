/**
 * Set matrix zero. If a cell is 0, then that row and column 
 * should be all set to 0. 
 * The idea was to use two arrays to keep track of which row 
 * and column need to be set to zero while traversing through 
 * the matrix. Then clean up rows and columns during second 
 * run. 
 */ 
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length; 
        
        if (m == 0) {
            return; 
        }
        
        int n = matrix[0].length; 
        
        if (n == 0) {
            return; 
        }
        
        boolean[] row = new boolean[m]; 
        boolean[] col = new boolean[n]; 
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true; 
                    col[j] = true; 
                }
            }
        }
        
        // clean up rows 
        for (int i = 0; i < m; i++) {
            if (row[i]) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0; 
                }
            }
        }
        
        // Clean up colums
        for (int j = 0; j < n; j++) {
            if (col[j]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0; 
                }
            }
        }
    }
}
