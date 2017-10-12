/*
Find the minimum element of a rotated sorted array with duplicated elements. 

NOTE: it cannot be solved by less than linear time worse case. e.g. n-1 1s and one 0. 
mid = i + (j - i) / 2

If nums[mid] < nums[j] --> recur on nums[i..mid]; 
If nums[mid] > nums[j] --> recur on nums[mid+1..j]; 
*** If nums[mid] == nums[j], don't know move left or right, It's safe to continue on nums[mid..j - 1], 
cause we don't lose any elements***

Time: O(n)
*/ 
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1; 
        }
        
        return helper(nums, 0, nums.length - 1);
    }
    
    private int helper(int[] nums, int i, int j) {
        if (i > j) {
            return -1;
        }
        
        if (i == j) {
            return nums[i]; 
        }
        
        int mid = i + (j - i) / 2; 
        
        if (nums[mid] == nums[j]) {
            return helper(nums, i, j - 1);
        } else if (nums[mid] < nums[j]){
            return helper(nums, i, mid);
        } else {
            return helper(nums, mid + 1, j);
        }
    }
}
