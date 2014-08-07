public class Solution {
    public int trap(int[] A) {
        int len = A.length; 
        if (len < 3) {
            return 0; 
        }
        
        int result = 0; 
        int leftMax = A[0]; 
        for (int i = 1; i < len - 1; i++) {
            if (A[i] >= leftMax) {
                leftMax = A[i]; 
            } else {
                // Find right max
                int rightMax = A[i + 1]; 
                for (int j = i + 1; j < len; j++) {
                    if (A[j] > rightMax) {
                        rightMax = A[j]; 
                    }
                }
                
                int minHeight = Math.min(leftMax, rightMax);
                
                if (minHeight > A[i]) {
                    result += minHeight - A[i]; 
                }
            }
        }
        
        return result; 
    }
}
