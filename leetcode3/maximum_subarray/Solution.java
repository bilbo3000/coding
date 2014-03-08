public class Solution {
    public int maxSubArray(int[] A) {
        int max = A[0]; 
        int maxx = A[0]; 
        
        for (int i = 1; i < A.length; i++) {
            maxx = Math.max(maxx + A[i], A[i]); 
            max = Math.max(max, maxx); 
        }
        
        return max; 
    }
}
