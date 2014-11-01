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
        
        int[] hang = new int[n]; 
        int result = 0; 
        
        for (int i = 0; i < m; i++) {
            // Build current hang line 
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    hang[j] = 0; 
                } else {
                    hang[j] += 1; 
                }
            }
            
            // Push to left and right 
            for (int j = 0; j < n; j++) {
                if (hang[j] != 0) {
                    int temp = hang[j]; 
                    
                    // Push to left 
                    int l = j - 1; 
                    
                    while (l >= 0 && hang[l] >= hang[j]) {
                        temp += hang[j]; 
                        l--; 
                    }
                    
                    // Push to right 
                    int r = j + 1; 
                    
                    while (r < n && hang[r] >= hang[j]) {
                        temp += hang[j]; 
                        r++; 
                    }
                    
                    result = Math.max(result, temp); 
                }
            }
        }
        
        return result; 
    }
}
