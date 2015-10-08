public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     * 
     * Start from up right corner. Increment count whenever find a target. 
     * Otherwise, move to left or down depending on the comparison. 
     * 
     * O(m + n) time, O(1) space. 
     */
    public int searchMatrix(int[][] matrix, int target) {
        int count = 0; 
        int m = matrix.length; 
        
        if (m == 0) {
            return 0; 
        }
        
        int n = matrix[0].length; 
        
        if (n == 0) {
            return 0; 
        }
        
        int i = 0; 
        int j = n - 1; 
        
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                count++; 
                j--; 
                continue; 
            } 
            
            if (matrix[i][j] < target) {
                i++; 
            } else {
                j--; 
            }
        }
        
        return count; 
    }
}

