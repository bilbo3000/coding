public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     * Calculate the max increasing continous subsequence and then 
     * calculate the max decreasing continous subsequence. 
     * O(n) time, O(1) space. 
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A.length == 0) {
            return 0; 
        }
        
        int res = 1; 
        
        // Increasing 
        int temp = 1; 
        
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                temp++; 
                res = Math.max(res, temp);
            } else {
                temp = 1; 
            }
        }
        
        // Decreasing
        temp = 1; 
        
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                temp++; 
                res = Math.max(res, temp);
            } else {
                temp = 1; 
            }
        }
        
        return res; 
    }
}
