public class Solution {
    /**
     * @param A an integer array
     * @param start an integer
     * @param end an integer
     * @return the number of possible answer
     * 
     * O(n^2)
     */
    public int subarraySumII(int[] A, int start, int end) {
        int i = 0; 
        int sum = 0; 
        int count = 0; 
        
        while (i < A.length) {
            int j = i; 
            sum = 0; 
            
            while (j < A.length) {
                sum += A[j]; 
                
                if (sum >= start && sum <= end) {
                    count++; 
                }
                
                j++; 
            }
            i++; 
        }
        
        return count; 
    }
}
