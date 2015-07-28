/**
 * Remove duplicates from sorted array. 
 * The idea was to shift to left one position whenever it 
 * finds a duplicates, and then reduce the length by 1. 
 */ 
public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length; 
        int i = 0; 
        
        while (i < len) {
            if (i < len - 1 && nums[i] == nums[i + 1]) {
                int j = i + 1; 
                
                while (j < len) {
                    nums[j - 1] = nums[j]; 
                    j++; 
                }
                
                len--; 
                i--; 
            }
            
            i++; 
        }
        
        return len; 
    }
}
