public class Solution {
    public int maxSubArray(int[] A) {
        int len = A.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        int maxx = A[0]; 
        int max = A[0]; 
        
        for (int i = 1; i < len; i++) {
            maxx = Math.max(A[i], maxx + A[i]); 
            max = Math.max(maxx, max); 
        }
        
        return max; 
    }
}
