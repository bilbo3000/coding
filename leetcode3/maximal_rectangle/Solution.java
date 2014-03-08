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
        
        int max = 0; 
        int[] h = new int[n]; 
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    h[j] = 0; 
                }
                else {
                    h[j] += 1; 
                }
            }
            
            // Push to both sides 
            for (int j = 0; j < n; j++) {
                if (h[j] != 0) {
                    int left = j; 
                    int right = j; 
                    
                    while (left > 0 && h[left - 1] >= h[j]) {
                        left--; 
                    }
                    
                    while (right < n - 1 && h[right + 1] >= h[j]) {
                        right++; 
                    }
                    
                    max = Math.max(max, (right - left + 1) * h[j]); 
                }
            }
        }
        
        return max; 
    }
}