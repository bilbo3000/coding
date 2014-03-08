public class Solution {
    public int trap(int[] A) {
        int result = 0; 
        int len = A.length; 
        
        if (len == 0) return result; 
        
        int leftMax = A[0]; 
        
        for (int i = 1; i < len; i++) {
            if (A[i] > leftMax) {
                leftMax = A[i]; 
            }
            else {
                // Search for right max
                int rightMax = A[i]; 
                
                for (int j = i + 1; j < len; j++) {
                    if (A[j] > rightMax) {
                        rightMax = A[j]; 
                    }
                }
                
                int temp = Math.min(leftMax, rightMax) - A[i]; 
                result += temp > 0 ? temp : 0;
            }
        }
        
        return result; 
    }
}
