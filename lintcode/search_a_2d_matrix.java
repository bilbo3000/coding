public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     * 
     * O(m + n)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; 
        
        if (m == 0) {
            return false; 
        }
        
        int n = matrix[0].length; 
        
        if (n == 0) {
            return false; 
        }
        
        int i = 0; 
        int j = n - 1; 
        
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true; 
            }
            
            if (matrix[i][j] > target) {
                // move left
                j--; 
            } else {
                // Move down
                i++; 
            }
        }
        
        return false; 
    }
}

