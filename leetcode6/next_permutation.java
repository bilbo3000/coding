/**
 * Find the next permutation. 
 * The idea was to make the minimum increment if possible. First find the first DROPING
 * point starting from the right. We want to increase that by the minimum amount by finding 
 * the first one that is larger than that element starting from the right. Make the swap 
 * between the two elements and then reverse the elements starting from the one after the 
 * DROPING point to the end to make the minimum increase. 
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length; 
        
        if (len == 0) {
            return; 
        }
        
        int i = len - 1; 
        
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--; 
        }
        
        if (i == 0) {
            Arrays.sort(nums);
            return; 
        }
        
        int j = len - 1; 
        
        while (nums[j] <= nums[i - 1]) {
            j--; 
        }
        
        int temp = nums[i - 1]; 
        nums[i - 1] = nums[j]; 
        nums[j] = temp; 
        
        int l = i; 
        int r = len - 1; 
        
        while (l < r) {
            temp = nums[l]; 
            nums[l] = nums[r]; 
            nums[r] = temp; 
            l++;
            r--; 
        }
        
        return; 
    }
}
