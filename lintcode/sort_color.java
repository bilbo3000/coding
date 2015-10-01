class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     * 
     * Two pointers. p1: the last 0; p2: the first 2. 
     * Stop after index i cross p2. Don't need to swap any more. 
     * O(n)
     */
    public void sortColors(int[] nums) {
        int p1 = -1; 
        int p2 = nums.length; 
        
        for (int i = 0; i < nums.length; i++) {
        	if (i >= p2) {
        		break; 
        	}
        	
            if (nums[i] == 0) {
                p1++; 
                swap(nums, p1, i);
            } else if (nums[i] == 2) {
                p2--; 
                swap(nums, i, p2); 
                i--; 
            }
        }
    }
    
    private void swap(int[] nums, int l, int r) {
        int temp = nums[l]; 
        nums[l] = nums[r]; 
        nums[r] = temp; 
    }
}
