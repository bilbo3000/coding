public class Solution {
    public int trap(int[] A) {
        int len = A.length; 
        int result = 0; 
        
        if (len == 0) {
            return 0; 
        }
        
        int lmax = A[0]; 
        int i = 1; 
        
        while (i < len - 1) {
            if (A[i] >= lmax) {
                lmax = A[i]; 
            } else {
                int rmax = A[i]; 
                int j = i; 
                
                while (j < len) {
                    if (A[j] > rmax) {
                        rmax = A[j]; 
                        
                        if (rmax >= lmax) {
                            break; 
                        }
                    }
                    
                    j++; 
                }
                
                result += Math.min(lmax, rmax) - A[i]; 
            }
            
            i++; 
        }
        
        return result; 
    }
}
