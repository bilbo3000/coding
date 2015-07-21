/**
 * Remove all instances of the given element from the array. 
 * The idea was, if find an instance of given element, replace that element 
 * with the last element in the array (if not the only element in the array). 
 * Then decrease the index to let it check the new element. Also decrease 
 * the length by 1. 
 */ 
public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length; 
        
        for (int i = 0; i < len; i++) {
            if (nums[i] == val) {
                if (len == 1) {
                    len--; 
                    break; 
                } else {
                    nums[i] = nums[len - 1]; 
                    len--; 
                    i--; 
                }
            }
        }
        
        return len; 
    }
}
