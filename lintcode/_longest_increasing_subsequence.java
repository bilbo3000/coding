public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     * 
     * Dynamic programming. 
     * 
     * O(n) time, O(n) speed. 
     */
    public int longestIncreasingSubsequence(int[] nums) {
        int len = nums.length; 
        
        if (len == 0) {
            return 0; 
        }
        int[] T = new int[len]; 
        T[0] = 1; 
        int max = 1; 
        
        for (int i = 1; i < len; i++) {
            T[i] = 1; 
            int j = i - 1; 
            
            while (j >= 0) {
                if (nums[i] >= nums[j]) {
                    T[i] = Math.max(T[i], T[j] + 1);
                    max = Math.max(max, T[i]);
                }
                
                j--; 
            }
        }
        
        return max; 
    }
}

