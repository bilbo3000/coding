public class Solution {
    public int maxSubArray(int[] A) {
        if (A.length == 0) {
            return 0; 
        }
        
        int maxx = A[0]; 
        int max = A[0]; 
        
        for (int i = 1; i < A.length; i++) {
            max = Math.max(max + A[i], A[i]);
            maxx = Math.max(maxx, max); 
        }
        
        return maxx; 
    }
}
