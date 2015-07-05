/**
 * The idea is based on the observation where 0 ^ 0 = 0; 1 ^ 1 = 0; 0 ^ 1 = 1. 
 * If XOR all the number together, numbers that appear twice will cancel each 
 * other, while the only single number will be left in the end. 
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int len = nums.length; 
        int result = 0; 
        
        if (len > 0) {
            result = nums[0]; 
        }
        
        for (int i = 1; i < len; i++) {
            result ^= nums[i]; 
        }
        
        return result; 
    }
}
