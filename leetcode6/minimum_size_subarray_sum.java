/**
 * Find the minimum length of continous array such that the sum is greater or equal to the given number. 
 * Sliding window approach. First find the first window. Then, each time push the left bound of the window
 * as far right as possible while maintain the property of the window. Update the result when left cannot 
 * push any further. Then advance right bound by position and repeatedly push left bound and update result. 
 * 
 * When to use sliding window approach？When it asks for [contigous] part of an array with some [max/min] 
 * property, where we can push left or right bound to get min/max. 
 */ 
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        
        if (len == 0) {
            return 0; 
        }
        
        int result = Integer.MAX_VALUE; 
        int sum = nums[0]; 
        int i = 0; 
        int j = 0; 
        
        while (j < len - 1 && sum < s) {
            j++; 
            sum += nums[j];
        }
        
        if (sum < s) {
            return 0; 
        }
        
        while (j < len) {
            // Push left as far right as possible
            while (i < j && (sum - nums[i] >= s)) {
                sum -= nums[i]; 
                i++; 
            }
            
            result = result = Math.min(result, j - i + 1);
            
            j++; 
            
            if (j < len) {
                sum += nums[j]; 
            }
        }
        
        return result; 
    }
}
