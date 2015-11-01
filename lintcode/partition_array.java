public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    int last = -1; 
	    
	    for (int i = 0; i < nums.length; i++) {
	        if (nums[i] < k) {
	            last++; 
	            swap(nums, last, i);
	        }
	    }
	    
	    return last + 1; 
    }
    
    private void swap(int[] nums, int l, int r) {
        int temp = nums[l]; 
        nums[l] = nums[r]; 
        nums[r] = temp; 
    }
}
