/**
 * Search the range of the given element. 
 * The idea was using binary search. Once found the target element, 
 * push both left and right as far as possible to find the range 
 * of the target element. 
 */ 
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0; 
        int r = nums.length - 1; 
        
        while (l <= r) {
            int mid = (l + r) / 2; 
            if (nums[mid] < target) {
                l = mid + 1; 
            } else if (nums[mid] > target) {
                r = mid - 1; 
            } else {
                int a = mid; 
                int b = mid; 
                
                while (a > 0 && nums[a - 1] == nums[mid]) {
                    a--; 
                }
                
                while (b < nums.length - 1 && nums[b + 1] == nums[mid]) {
                    b++; 
                }
                
                return new int[] {a, b}; 
            }
        }
        
        return new int[] {-1, -1}; 
    }
}
