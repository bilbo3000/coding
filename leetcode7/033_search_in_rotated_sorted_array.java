/*
Search an element in a rotated sorted array of UNIQUE elements in O(logn)

O(logn) --> binary search; 
Find middle: mid = i + (j - i) / 2; 
Note that this way if odd number of elements: 
--> middle element; 
If even number of elements, 
--> the first element of middle pair; 

If mid is target, return mid; 

If nums[i..mid] is sorted: 
    a) if target in nums[i..mid]: recur on nums[i..mid-1];
    b) else recur on nums[mid+1..j];

Otherwise, nums[mid..j] must be sorted (can only have one pivot point): 
    a) if target in nums[mid..j]: recur on nums[mid+1..j]; 
    b) else recur on nums[i..mid-1];
*/
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1; 
        }
        
        return binarySearch(nums, target, 0, nums.length - 1);
    }
    
    private int binarySearch(int[] nums, int target, int i, int j) {
        if (i > j) {
            return -1; 
        }
        
        if (i == j) {
            if (nums[i] == target) {
                return i; 
            }
            
            return -1; 
        }
        
        int mid = i + (j - i) / 2; 
        
        if (nums[mid] == target) {
            return mid; 
        } else if (nums[i] <= nums[mid]) {
            // nums[i..mid] is sorted
            if (nums[i] <= target && target <= nums[mid]) {
                // Continue search on nums[i..mid - 1]
                return binarySearch(nums, target, i, mid - 1);
            } else {
                // Continue search on nums[mid + 1..j]
                return binarySearch(nums, target, mid + 1, j);
            }
        } else {
            // nums[mid..j] must be sorted
            if (nums[mid] <= target && target <= nums[j]) {
                // Continue search on nums[mid + 1..j]
                return binarySearch(nums, target, mid + 1, j);
            } else {
                // Continue search on nums[i, mid - 1]
                return binarySearch(nums, target, i, mid - 1);
            }
        }
    }
}
