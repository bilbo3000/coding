/**
 * Find a continous sub array such that its product is maximized. 
 * Solve it using dynamic programming. The idea was to maintain two arrays, max and min, 
 * such that max[i] is the max product upto nums[i] and min[i] is the min product upto nums[i]. 
 * The reason is that if nums[i] is poduct, we look at max[i - 1] to determine max[i]. However, 
 * if nums[i] is negative, we want to look smaller product upto i - 1 in order to invert to 
 * max product max[i]. Thus we need to maintain max and min array. 
 */ 
public class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        int[] max = new int[len];
        int[] min = new int[len];
        max[0] = nums[0]; 
        min[0] = nums[0]; 
        int res = max[0]; 
        
        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                max[i] = Math.max(nums[i], nums[i] * max[i - 1]);
                min[i] = Math.min(nums[i], nums[i] * min[i - 1]);
            } else {
                max[i] = Math.max(nums[i], nums[i] * min[i - 1]);
                min[i] = Math.min(nums[i], nums[i] * max[i - 1]);
            }
            
            res = Math.max(res, max[i]);
        }
        
        return res; 
    }
}
