/**
 * Find the max money you can rob from a list of houses, where no adjacent 
 * houses can be robbed. 
 * The idea was to use dynamic programming. Use T[i] to represent the max 
 * money we can rob if we rob the ith house. Thus, we just need to find the 
 * max from T[i - 2] to T[0] and add it to the amount of money the ith house
 * has to get T[i]. Since we cannot rob adjacent house, thus it does not 
 * start with T[i - 1]. 
 */ 
public class Solution {
    public int rob(int[] nums) {
        int len = nums.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        int result = 0; 
        int[] T = new int[len];
        
        T[0] = nums[0]; 
        result = nums[0]; 
        
        if (len >= 2) {
            T[1] = nums[1]; 
            result = Math.max(result, T[1]); 
        }
        
        for (int i = 2; i < len; i++) {
            int temp = nums[i]; 
            
            for (int j = i - 2; j >= 0; j--) {
                temp = Math.max(temp, nums[i] + T[j]); 
            }
            
            T[i] = temp; 
            result = Math.max(result, temp); 
        }
        
        return result; 
    }
}
