/**
 * Find the maximal square in the matrix. 
 * Use the hangline approach. Mainline a hangline while go 
 * through each level. For each hangline, try to push the 
 * hangline as right and as left as possible, to find the 
 * rectangle area. The square would be the square of the 
 * smaller edge. Keep updating the max area while iterating 
 * through the matrix. 
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length; 
        
        if (m == 0) {
            return 0; 
        }
        
        int n = matrix[0].length; 
        
        if (n == 0) {
            return 0; 
        }
        
        int[] h = new int[n]; 
        int result = 0; 
        
        for (int i = 0; i < m; i++) {
            // Update hangline
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    h[j] = 0; 
                } else {
                    h[j] += 1; 
                }
            }
            
            // Push hangline to both sides to get area
            for (int j = 0; j < n; j++) {
                int l = j; 
                
                while (l > 0 && h[l - 1] >= h[j]) {
                    l--; 
                }
                
                int r = j; 
                
                while (r < n - 1 && h[r + 1] >= h[j]) {
                    r++; 
                }
                
                int temp = (int) Math.pow(Math.min(h[j], r - l + 1), 2); 
                result = Math.max(result, temp); 
            }
        }
        
        return result; 
    }
}
