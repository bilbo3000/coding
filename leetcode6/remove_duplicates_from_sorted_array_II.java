/**
 * Remove duplicates from a sorted array where each number is allowed at most 
 * two duplicates. 
 * The idea was to go through the array and check the before and after of each 
 * element. the it is the same as the before and after, shift the rest array to 
 * the left one position and decrease length by one. 
 */ 
public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length; 
        int i = 0; 
        
        while (i < len) {
            if (i > 0 && i < len - 1 && nums[i - 1] == nums[i] && nums[i] == nums[i + 1]) {
                int j = i + 1; 
                
                while (j < len) {
                    nums[j - 1] = nums[j]; 
                    j++; 
                }
                i--; 
                len--; 
            }
            
            i++; 
        }
        
        return len; 
    }
}
