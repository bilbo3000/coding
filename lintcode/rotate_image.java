public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     * 
     * O(n^2)
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length; 
        
        for (int level = 0; level < (n + 1) / 2; level++) {
            for (int i = level; i < n - 1 - level; i++) {
                int temp = matrix[level][i]; 
                matrix[level][i] = matrix[n - 1 - i][level]; 
                matrix[n - 1 - i][level] = matrix[n - 1 - level][n - 1 - i]; 
                matrix[n - 1 - level][n - 1 - i] = matrix[i][n - 1 - level];
                matrix[i][n - 1 - level] = temp; 
            }
        }
    }
}
