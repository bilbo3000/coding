/**
 * Find the array of products of all numbers except the current number. 
 * The core idea was that the value for each number would be the product of all the numbers 
 * to its left and all the number to its right. The idea was to process the array in two 
 * passes. First pass runs from left to right and update result[i] to be the product of 
 * all the numbers to its left. result[0] would be 1. The second pass walk from right to 
 * left and update result[i] to include the product of all numbers to its right. Note that 
 * the product can be accumulate and carry to next position, thus there is no need to 
 * go through everything each time. 
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length; 
        
        if (len == 0) {
            return new int[0]; 
        }
        
        int[] res = new int[len]; 
        // First pass, res[i] is the product of the numbers to its left 
        int left = 1; 
        
        for (int i = 0; i < len; i++) {
            res[i] = left; 
            left = left * nums[i]; 
        }
        
        // Second pass backward, update res[i] to include the product of numbers to its right
        int right = 1;  // Current product of right numbers 
        
        for (int i = len - 1; i >= 0; i--) {
            res[i] = res[i] * right; 
            right = right * nums[i]; 
        }
        
        return res; 
    }
}
