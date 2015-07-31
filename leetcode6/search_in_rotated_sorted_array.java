/**
 * Search an element in a rotated array. 
 * The idea was to first find the last element before rotation point. Then 
 * using binary search in the before or the after section, depending on 
 * which section the target falls into. 
 */ 
public class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length; 
        
        if (len == 0) {
            return -1;
        }
        
        int i = 0; 
        
        while (i < len - 1 && nums[i] < nums[i + 1]) {
            i++; 
        }
        
        if (target >= nums[0] && target <= nums[i]) {
            return binarySearch(nums, 0, i, target); 
        } else {
            return binarySearch(nums, i + 1, len - 1, target);
        }
    }
    
    private int binarySearch(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        
        int mid = (l + r) / 2; 
        
        if (nums[mid] == target) {
            return mid; 
        } else if (nums[mid] > target) {
            return binarySearch(nums, l, mid - 1, target); 
        } else {
            return binarySearch(nums, mid + 1, r, target);
        }
    }
}
