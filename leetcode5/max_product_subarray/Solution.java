public class Solution {
    public int maxProduct(int[] A) {
        int len = A.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        if (len == 1) {
            return A[0];
        }
        
        int[] maxarr = new int[len]; 
        int[] minarr = new int[len];
        
        maxarr[0] = A[0]; 
        minarr[0] = A[0]; 
        
        for (int i = 1; i < len; i++) {
            if (A[i] >= 0) {
                maxarr[i] = Math.max(A[i], maxarr[i - 1] * A[i]); 
                minarr[i] = Math.min(A[i], minarr[i - 1] * A[i]); 
            } else {
                maxarr[i] = Math.max(A[i], minarr[i - 1] * A[i]); 
                minarr[i] = Math.min(A[i], maxarr[i - 1] * A[i]); 
            }
        }
        
        int max = maxarr[0]; 
        
        for (int i = 1; i < len; i++) {
            if (maxarr[i] > max) {
                max = maxarr[i]; 
            }
        }
        
        return max; 
    }
}
