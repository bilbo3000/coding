/*
Find the minimum element in a rotated sorted array in O(logn)

O(logn) --> binary search. 

mid = i + (j - 1) / 2

The idea is that if nums[mid] <= nums[j], min must be in nums[i..mid]
Note that nums[mid] could be min; 
If nums[mid] > nums[j], min must be in nums[mid+1..j]
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
        
        if (nums[mid] <= nums[j]) {
            return helper(nums, i, mid); 
        } else {
            return helper(nums, mid + 1, j);
        }
    }
}
