/**
 * Find the contiguous subarray with max sum. 
 * O(n) solution using dynamic programming. 
 * Define and array T[N] where T[i] stores the max sum of contiguous subarray 
 * ending with element nums[i]. Thus, the nums[i], it has two choices, 1) join
 * the lastest subarray to increase its sum; 2) start a new subarray; The two 
 * choices depending on which is larger. While filling out T, updating the max 
 * sum meanwhile. 
 */ 
public class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        int[] T = new int[len];  // T[i]: max sum ending at element nums[i]
        T[0] = nums[0]; 
        int max = T[0]; 
        
        for (int i = 1; i < len; i++) {
            T[i] = Math.max(nums[i], T[i - 1] + nums[i]); 
            
            if (T[i] > max) {
                max = T[i]; 
            }
        }
        
        return max; 
    }
}
