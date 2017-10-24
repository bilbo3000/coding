/*
Rotate an image layer by layer clockwise.

Time: O(n^2)
Space: O(1)
*/
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return; 
        }
        
        int n = matrix.length; 
        
        // Rotate layer by layer 
        for (int i = 0; i < Math.floor(n / 2); i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j]; 
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]; 
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp; 
            }
        }
    }
}
