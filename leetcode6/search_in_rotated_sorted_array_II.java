/**
 * Search an element in a rotated array with duplicates. 
 * First find the last element before rotation point. The do binary 
 * search in the before or after section depending on which section 
 * the target falls into. 
 */ 
public class Solution {
    public boolean search(int[] nums, int target) {
        int len = nums.length; 
        
        if (len == 0) {
            return false; 
        }
        
        int i = 0; 
        
        while (i < len - 1 && nums[i] <= nums[i + 1]) {
            i++; 
        }
        
        if (target >= nums[0] && target <= nums[i]) {
            return binarySearch(nums, 0, i, target);
        } else {
            return binarySearch(nums, i + 1, len - 1, target); 
        }
    }
    
    private boolean binarySearch(int[] nums, int l, int r, int target) {
        if (l > r) {
            return false;
        }
        
        int mid = (l + r) / 2; 
        
        if (nums[mid] == target) {
            return true;
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, r, target);
        } else {
            return binarySearch(nums, l, mid - 1, target); 
        }
    }
}
