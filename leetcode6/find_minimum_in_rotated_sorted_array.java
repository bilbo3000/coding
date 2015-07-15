/**
 * Find the minimum number of a pivoted array. 
 * The idea was to iterate through the array and return the first element that 
 * is smaller than the one before it. If such element does not exist, return 
 * the first element. 
 */
public class Solution {
    public int findMin(int[] nums) {
        int length = nums.length; 
        
        if (length == 0) {
            return 0; 
        }
        
        int i = 1; 
        
        while (i < length && nums[i] > nums[i - 1]) {
            i++; 
        }
        
        if (i == length) {
            return nums[0]; 
        }
        
        return nums[i]; 
    }
}
