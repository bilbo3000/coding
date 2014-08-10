public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max = 0; 
        int m = matrix.length; 
        
        if (m == 0) {
            return 0; 
        }
        
        int n = matrix[0].length; 
        
        if (n == 0) {
            return 0; 
        }
        
        int[] h = new int[n]; 
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    h[j] = 0; 
                } else {
                    h[j] += 1; 
                }
            }
            
            for (int j = 0; j < n; j++) {
                if (h[j] > 0) {
                    int a = j; 
                    int b = j; 
                    
                    while (a > 0 && h[a - 1] >= h[j]) {
                        a--; 
                    }
                    
                    while (b < n - 1 && h[b + 1] >= h[j]) {
                        b++; 
                    }
                    
                    max = Math.max(max, h[j] * (b - a + 1)); 
                }
            }
        }
        
        return max; 
    }
}
