/**
 * The idea is to swap each number to its correct position if able to swap. 
 * Then the last element would just be the duplicated one. 
 * 
 * O(n) time; O(1) space; 
 */ 
public class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1); 
                i--; 
            }
        }
        
        return nums[nums.length - 1]; 
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i]; 
        nums[i] = nums[j]; 
        nums[j] = temp; 
    }
}
