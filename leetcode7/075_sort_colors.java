/*
Sort three colors. 

Two pointers: 
p1 points to the index of last 0; 
p2 points to the index of first 2; 

Walk through the array and stop if i cross p2; 
If see a 0, advance p1 and swap nums[i] with nums[p1]; 
NOTE, no need to re-examine swapped in element, because previous 
elements prior to i all processed, can only be 1; already at 
right localtion; 
If see a 2, decrease p2 and swap nums[i] with nums[p2];
NOTE, need to re-examie swapped in element, cause it could be 0, 1, or 2; 
*/
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return; 
        }
        
        int len = nums.length; 
        int lastZero = -1; 
        int firstTwo = len; 
        
        for (int i = 0; i < len; i++) {
            if (i >= firstTwo) {
                break; 
            }
            
            if (nums[i] == 0) {
                lastZero++; 
                swap(nums, lastZero, i);
            } else if (nums[i] == 2) {
                firstTwo--; 
                swap(nums, i, firstTwo);
                // Need to re-examine the swapped in elelent
                // Could be a 0, 1, or 2, need to handle
                i--;
            }
        }
        
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i]; 
        nums[i] = nums[j]; 
        nums[j] = temp; 
    }
}
