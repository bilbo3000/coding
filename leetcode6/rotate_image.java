/**
 * Rotate a square image to the right for 90 degrees. 
 * The idea was to rotate level by level, and there are (n + 1) / 2 levels. 
 */ 
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length; 
        
        if (n == 0 || n == 1) { 
            return; 
        } 
        
        for (int level = 0; level < (n + 1) / 2; level++) { 
            for (int i = level; i < n - level - 1; i++) {
                int temp = matrix[level][i]; 
                matrix[level][i] = matrix[n - 1 - i][level]; 
                matrix[n - 1 - i][level] = matrix[n - level - 1][n - 1 - i]; 
                matrix[n - level - 1][n - 1 - i] = matrix[i][n - level - 1]; 
                matrix[i][n - level - 1] = temp; 
            }
        }
    }
}
