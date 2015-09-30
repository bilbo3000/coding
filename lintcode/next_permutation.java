public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     * 
     * Make minimum increment. Thus need to find the first dipping point. Then 
     * find the first(smallest) element search backwards that is greater than 
     * it. Swap the two, and reverse the remaining part to make decreasing again.
     * This would be minimum increase. 
     * 
     * O(n)
     */
    public int[] nextPermutation(int[] nums) {
        int len = nums.length; 
        int j = len - 2; 
        
        while (j >= 0 && nums[j] >= nums[j + 1]) {
            j--; 
        }
        
        if (j < 0) {
            int l = 0; 
            int r = len - 1; 
            
            while (l < r) {
                int temp = nums[l]; 
                nums[l] = nums[r]; 
                nums[r] = temp;
                l++; 
                r--; 
            }
        } else {
            int i = len - 1; 
            
            while (i > j && nums[i] <= nums[j]) {
                i--; 
            }
            
            // swap nums[i] and nums[j]
            int temp = nums[i]; 
            nums[i] = nums[j]; 
            nums[j] = temp; 
            
            // Reverse nums[j + 1:]
            int l = j + 1; 
            int r = len - 1; 
            
            while (l < r) {
                int t = nums[l]; 
                nums[l] = nums[r]; 
                nums[r] = t; 
                l++; 
                r--; 
            }
        }
        
        return nums;
    }
}
