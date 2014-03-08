public class Solution {
    public int trap(int[] A) {
        int result = 0; 
        int len = A.length; 
        
        if (len == 0 || len == 1 || len == 2) {
            return 0;
        }
        
        int left = A[0]; 
        
        for (int i = 1; i < len - 1; i++) {
            if (A[i] >= left) {
                left = A[i]; 
                continue;
            }
            
            int k = i + 1; 
            int right = A[k]; 
            
            while (k < len) {
                if (A[k] > right) {
                    right = A[k]; 
                }
                
                k++; 
            }
            
            int min = Math.min(left, right); 
            
            if (min > A[i]) {
                result += min - A[i]; 
            }
        }
        
        return result; 
    }
}
