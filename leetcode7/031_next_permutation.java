/*
Find the next permutation of a given string. 

The idea was to increase the string value as least as possible. 
Reading backwards, need to find the first element nums[i] that is smaller than its successor. 
(imply that nums[i + 1:] is in descending order). 

To make smallest possible increment, need to find the smallest element in nums[i + 1:] that 
is greater than nums[i], swap it with nums[i], and reverse the nums[i + 1:] to be descending. 

Time: O(n)
Space: O(1)
*/
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null) {
            return; 
        }
        
        int len = nums.length; 
        
        if (len == 0 || len == 1) {
            return; 
        }
        
        int i = len - 2; 
        
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--; 
        }
        
        if (i < 0) {
            // Entire array is in decreasing order
            // Reverse the array
            reverse(nums, 0, len - 1);
            return; 
        }
        
        // nums[i] is the first element smaller than nums[i + 1] in reverse order
        int j = len - 1; 
        
        while (j > i && nums[j] <= nums[i]) {
            j--; 
        }
        
        // nums[j] must be the first element greater than num[i] in reverse order
        // Swap nums[i] nums[j]
        int temp = nums[i]; 
        nums[i] = nums[j]; 
        nums[j] = temp; 
        
        // Reverse nums[i + 1:] to make it the smallest possible 
        reverse(nums, i + 1, len - 1); 
        return; 
    }
    
    private void reverse(int[] nums, int i, int j) {
        
        while (i < j) {
            int temp = nums[i]; 
            nums[i] = nums[j]; 
            nums[j] = temp; 
            i++; 
            j--; 
        }
    }
}
