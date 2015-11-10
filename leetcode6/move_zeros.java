/**
 * When find a zero, shift bits to left and move the bit to the end. 
 */ 
public class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length; 
        int i = 0; 
        
        while (i < len) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < len; j++) {
                    nums[j - 1] = nums[j]; 
                }
                
                nums[len - 1] = 0; 
                i--; 
                len--; 
            }
            
            i++; 
        }
    }
}
