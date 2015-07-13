/**
 * Search the target value in the given array. Returns its index if 
 * found. Otherwise, returns the index where the target should be inserted.
 * 
 * Linear approach. Loop through the array until it either 
 * 1) reaches the end; 
 * 2) finds the target; 
 * 3) finds the first value that is greater or equal to the target.  
 * In all three cases, return index would work. 
 */ 
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0; 
        
        while (i < nums.length && nums[i] < target) {
            i++; 
        }
        
        return i; 
    }
}
