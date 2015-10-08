public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     * 
     * The idea was first use binary search find the row that could contain the
     * candidate. Do the binary search on the last column. Once we have a row, 
     * do binary search on that row to find the target. 
     * 
     * O(logm + logn)
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
        
        int l = 0; 
        int r = m - 1; 
        
        while (l <= r) {
            int mid = (l + r) / 2; 
            
            if (matrix[mid][n - 1] == target) {
                return true; 
            }
            
            if (matrix[mid][n - 1] > target) {
                r = mid - 1; 
            } else {
                l = mid + 1;   
            } 
        }
        
        if (l >= m) {
            return false; 
        }
        
        int a = 0; 
        int b = n - 1; 
        
        while (a <= b) {
            int mid = (a + b) / 2; 
            
            if (matrix[l][mid] == target) {
                return true; 
            }
            
            if (matrix[l][mid] > target) {
                b = mid - 1; 
            } else {
                a = mid + 1; 
            }
        }
        
        return false; 
    }
}

