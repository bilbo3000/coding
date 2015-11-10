/**
 * Maintain a pointer points to the last non-zero element. 
 * While traversing through the list, if find a non-zero element, increment 
 * the index and swap it with the current element. 
 */ 
public class Solution {
    public void moveZeroes(int[] nums) {
        int last = -1; // index of last non zero 
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                last++; 
                swap(nums, last, i); 
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i]; 
        nums[i] = nums[j]; 
        nums[j] = temp; 
    }
}
