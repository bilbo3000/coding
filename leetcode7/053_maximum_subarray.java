/*
Find the max subarray. 

Walk through the array. Maintain the max subarray and a global maximum value. 
The max ending at current elemnt is either current element plus previous max, 
or just the current element (depending on who is larger). 

Time: O(n); 
Space: O(1);
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length; 
        int result = nums[0]; 
        int max = nums[0];  // Max contiguous array ending at current element
        
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max + nums[i], nums[i]);
            result = Math.max(result, max);
        }
        
        return result; 
    }
}
