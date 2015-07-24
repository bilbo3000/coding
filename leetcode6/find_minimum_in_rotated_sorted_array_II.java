/**
 * Find the minimum in rotated sorted array. 
 * The idea was to loop through the list and try to find the 
 * first element that is smaller than the one before. If 
 * such elements exists, return it. Otherwise, return the first 
 * element. 
 */ 
public class Solution {
    public int findMin(int[] nums) {
        int len = nums.length; 
        
        if (len == 0) {
            return 0;
        }
        
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1]; 
            }
        }
        
        return nums[0]; 
    }
}
