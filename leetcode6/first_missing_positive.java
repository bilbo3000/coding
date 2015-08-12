/**
 * Find the first missing positive number. 
 * The idea was to use the value in the array as the index in another array. 
 * First find the max positive value in the array if possible so we know the 
 * size of the second array. Then go through the array and use each value as 
 * the index and set the flag in the second array at that index. Last, we can 
 * walk through the second array and find the first unflag position and its 
 * index would be the result. 
 * Lesson: use value as index would help with ordering the elements.  
 */ 
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length; 
        
        if (len == 0) {
            return 1; 
        }
        
        int max = nums[0]; 
        
        for (int i = 1; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i]; 
            }
        }
        
        if (max <= 0) {
            return 1; 
        }
        
        boolean[] arr = new boolean[max];
        
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                int index = nums[i] - 1; 
                arr[index] = true; 
            }
        }
        
        int i = 0; 
        
        while (i < max && arr[i]) {
            i++; 
        }
        
        return i + 1; 
    }
}
