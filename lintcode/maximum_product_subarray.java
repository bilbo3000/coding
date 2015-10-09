public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     * 
     * Dynamic programming. Maintain two array, max and min. 
     * For positive number, look at max for max and min for min. 
     * For negative number, look at max for min and min for max. 
     * 
     * O(n)
     */
    public int maxProduct(int[] nums) {
        int len = nums.length; 
        int[] max = new int[len]; 
        int[] min = new int[len]; 
        max[0] = nums[0]; 
        min[0] = nums[0]; 
        int maxx = max[0]; 
        
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                max[i] = Math.max(max[i - 1] * nums[i], nums[i]);
                min[i] = Math.min(min[i - 1] * nums[i], nums[i]);
                
                if (max[i] > maxx) {
                    maxx = max[i]; 
                }
            } else {
                max[i] = Math.max(min[i - 1] * nums[i], nums[i]);
                min[i] = Math.min(max[i - 1] * nums[i], nums[i]);
                
                if (max[i] > maxx) {
                    maxx = max[i]; 
                }
            }
        }
        
        return maxx; 
    }
}
