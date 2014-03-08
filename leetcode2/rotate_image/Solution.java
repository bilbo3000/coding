public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length; 
        
        if (n == 0) return; 
        
        for (int level = 0; level < n / 2; level++) {
            for (int i = 0; i < n - 2 * level - 1; i++) {
                int temp = matrix[level][level + i]; 
                matrix[level][level + i] = matrix[n - 1 - level - i][level]; 
                matrix[n - 1 - level - i][level] = matrix[n - 1 - level][n - 1 - level - i]; 
                matrix[n - 1 - level][n - 1 - level - i] = matrix[level + i][n - 1 - level]; 
                matrix[level + i][n - 1 - level] = temp; 
            }
        }
    }
}
