/**
 * Find maximal rectangle in a matrix. 
 * Use the hangline approach. The ideas was to maintain a hangline while 
 * going through each row. Reset hangline to 0 if current element is 0. 
 * Otherwise, increase the length of lengline by 1. For each hangline, 
 * try to push to as left and as right as possible. The rectangle area 
 * would be the length of hangline times the difference between left and 
 * right index. Keep updating the max rectangle while going through the 
 * matrix. 
 */ 
public class Solution {
    public int maximalRectangle(char[][] matrix) {
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
            
            // Get area
            for (int j = 0; j < n; j++) {
                int l = j; 
                
                while (l > 0 && h[l - 1] >= h[j]) {
                    l--; 
                }
                
                int r = j; 
                
                while (r < n - 1 && h[r + 1] >= h[j]) {
                    r++; 
                }
                
                result = Math.max(result, h[j] * (r - l + 1)); 
            }
        }
        
        return result; 
    }
}
