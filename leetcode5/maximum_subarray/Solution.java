public class Solution {
    public int maxSubArray(int[] A) {
        int len = A.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        int[] T = new int[len]; 
        T[0] = A[0]; 
        int result = A[0]; 
        
        for (int i = 1; i < len; i++) {
            T[i] = Math.max(T[i - 1] + A[i], A[i]); 
            result = Math.max(result, T[i]); 
        }
        
        return result; 
    }
}
