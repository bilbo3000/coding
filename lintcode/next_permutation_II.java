public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     * 
     * O(n), this approach works no matter the input contains duplicates or not.
     */
    public void nextPermutation(int[] nums) {
        int len = nums.length; 
        int i = len - 2; 
        
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--; 
        }
        
        if (i < 0) {
            // No possible next permutation 
            reverse(nums, 0, len - 1);
        } else {
            // nums[i] is the first dipping point search backward 
            int j = len - 1; 
            
            while (j > i && nums[j] <= nums[i]) {
                j--; 
            }
            
            int temp = nums[i]; 
            nums[i] = nums[j]; 
            nums[j] = temp; 
            
            reverse(nums, i + 1, len - 1); 
        }
    }
    
    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l]; 
            nums[l] = nums[r]; 
            nums[r] = temp; 
            l++; 
            r--; 
        }
    }
}
