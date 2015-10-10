public class Solution {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     * 
     * There cannot be any duplicates. Thus, we need to swap current with the 
     * element at the index current element should be. Then re-exam the incoming
     * element. Note, if current element is N, don't swap. 
     * 
     * O(n) time, in place. 
     */
    public int findMissing(int[] nums) {
        int i = 0; 
        
        while (i < nums.length) {
            if (nums[i] != i) {
                // Possible need to swap
                if (nums[i] != nums.length) {
                    // Can't swap N
                    swap(nums, i, nums[i]);
                    i--; 
                }
            }
            
            i++; 
        }
        
        i = 0; 
        
        while (i < nums.length) {
            if (nums[i] != i) {
                return i; 
            }
            
            i++; 
        }

        return i; 
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i]; 
        nums[i] = nums[j]; 
        nums[j] = temp; 
    }
}
