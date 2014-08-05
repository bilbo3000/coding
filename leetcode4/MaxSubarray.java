public class Solution {
    public int maxSubArray(int[] A) {
        int len = A.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        int[] T = new int[len];  // T[i]: max sum ending at A[i]
        T[0] = A[0]; 
        int max = T[0]; 
        
        for (int i = 1; i < len; i++) {
            if (T[i - 1] + A[i] < A[i]) {
                T[i] = A[i]; 
            } else {
                T[i] = A[i] + T[i - 1]; 
            }
            
            if (T[i] > max) {
                max = T[i]; 
            }
        }
        
        return max; 
    }
}
