/*
Search for a range. 

Search the range of the given element in a sorted array in O(logn). 

This approach is to use binary search to find an index of the given element. 
Then try to expand from the index to the left and right. 

However, this approach has worst time complexity O(n), where all elements are
the same in the array. 
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        
        int res = binarySearch(nums, 0, nums.length - 1, target);
        
        if (res == -1) {
            return new int[] {-1, -1};
        }
        
        int left = res; 
        int right = res; 
        
        while (left > 0 && nums[left - 1] == nums[left]) {
            left--; 
        }
        
        while (right < nums.length - 1 && nums[right + 1] == nums[right]) {
            right++; 
        }
        
        return new int[]{left, right};
    }
    
    private int binarySearch(int[] nums, int i, int j, int target) {
        if (i > j) {
            return -1; 
        }
        
        if (i == j) {
            if (nums[i] == target) {
                return i; 
            } else {
                return -1; 
            }
        }
        
        int mid = i + (j - i) / 2; 
        if (nums[mid] == target) {
            return mid; 
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, j, target);
        } else {
            return binarySearch(nums, i, mid - 1, target);
        }
    }
}
