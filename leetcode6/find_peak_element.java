/**
 * Find the peak element. 
 * Linear approach. Walk through the list and check each element. Return 
 * index whenever we find a peak element. 
 */ 
public class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length; 
        
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                if (i + 1 < len && nums[i] > nums[i + 1]) {
                    return i; 
                }
            } else if (i == len - 1) {
                if (i - 1 >= 0 && nums[i - 1] < nums[i]) {
                    return i; 
                }
            } else {
                if (i - 1 >= 0 && i + 1 < len && nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                    return i; 
                }
            }
        }
        
        return 0; 
    }
}
