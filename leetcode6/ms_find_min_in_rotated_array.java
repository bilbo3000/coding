/**
 * Find min in a rotated array. The idea was to have two pointers pointing 
 * to left and right edges. 
 * Each time find the middle point mid = l + (r - l) / 2; If the middle point
 * fall into the first segment, move l to mid; otherwise, move r to mid; 
 * Thus, two pointers move towards to each other. 
 * 
 * The termination condition of the loop is while (l < r - 1) { ... }, 
 * The advantage of this condition is that l and r will never overldap. 
 * And after jump out of the loop, l must points largest element and r must 
 * point to smallest. Thus we just need to return the element pointed by r. 
 */ 
public class Solution {
    public int findMin(int[] nums) {
        int len = nums.length; 
        
        if (nums[0] <= nums[len - 1]) {
            return nums[0]; 
        }
        
        int l = 0; 
        int r = len - 1; 
        
        while (l < r - 1) {
            int mid = l + (r - l) / 2; 
            
            if (nums[mid] >= nums[0]) {
                l = mid;
            } else {
                r = mid; 
            }
        }
        
        return nums[r]; 
    }
}
