/**
 * Search the given target in a matrix. 
 * Start from upper right corner. If current element is less than the 
 * target, move down to find something larger. If current element is 
 * larger than the target, move left to find something smaller. Until 
 * we find the target or cannot move. We start from upper right corner 
 * is because we only want to have one direction each time we move. 
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
