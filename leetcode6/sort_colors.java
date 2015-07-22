/**
 * Sort color, partition approach. 
 * Two pointers. First one points to the last zero and second one points 
 * to last one. They start off as -1. While iterate through the array, 
 * if it encounters a 1, we need to increment lastOne pointer and swap the 
 * two elements. This case we don't need to re-examine the incoming element 
 * because it is guarentee to be a 2. If it encounters a 0, we need to increase
 * lastZero pointer and swap the two elements. This time, first we need to check 
 * if lastOne falls behind lastZero, we need to set lastOne to be lastZero, 
 * which happens at the very beginning. lastOne cannot fall behind lastZero. 
 * Second, after swap the two elements, we need to re-examine the incomming element, 
 * because it could be a one or two (the case where it does not have ones). 
 */ 
public class Solution {
    public void sortColors(int[] nums) {
        int lastZero = -1; 
        int lastOne = -1; 
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                lastZero++; 
                
                if (lastOne < lastZero) {
                    lastOne = lastZero; 
                }
                
                if (lastZero != i && lastZero < nums.length) {
                    int temp = nums[i]; 
                    nums[i] = nums[lastZero]; 
                    nums[lastZero] = temp; 
                    i--; 
                }
            } else if (nums[i] == 1) {
                lastOne++; 
                
                if (lastOne != i && lastOne < nums.length) {
                    int temp = nums[i]; 
                    nums[i] = nums[lastOne]; 
                    nums[lastOne] = temp; 
                }
            } 
        }
    }
}
