/**
 * Search an element in a 2D matrix. 
 * The idea was to start from upper right corner. If current element is 
 * less than the target, move down. If current element is greater than 
 * target, move left. Until find the target or cannot move any more. 
 */ 
public class Solution {
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

        while (true) {
            if (matrix[i][j] == target) {
                return true; 
            } else if (matrix[i][j] < target) {
                if (i < m - 1) {
                    i++;
                } else {
                    break;
                }
            } else {
                if (j > 0) {
                    j--; 
                } else {
                    break; 
                }
            }
        }
        
        return false; 
    }
}
