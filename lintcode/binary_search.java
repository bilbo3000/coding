class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     * 
     * O(log n)
     */
    public int binarySearch(int[] nums, int target) {
        int len = nums.length; 
        int l = 0; 
        int r = len - 1; 
        int result = -1; 
        
        while (l <= r) {
            int mid = (l + r) / 2; 
            
            if (nums[mid] == target) {
                result = mid; 
                break; 
            }
            
            if (nums[mid] < target) {
                l = mid + 1;  
            } else {
                r = mid - 1; 
            }
        }
        
        while (result > 0 && nums[result] == nums[result - 1]) {
            result--; 
        }
        
        return result; 
    }
}
