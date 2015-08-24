/**
 * Find the first missing number of a given array. 
 * The idea was that if current element is not equal to its index. Try to swap it with the 
 * element at the index as the value. If cannot swap (out of index or the other element is 
 * the same), update the index that tracks missing element. Otherwise,  swap and reexamime 
 * the incoming element. 
 */ 
public class Solution {
    public int missingNumber(int[] nums) {
        int i = 0; 
        int len = nums.length; 
        int last = -1; 
        
        while (i < len) {
            if (nums[i] != i) { 
                if (nums[i] < len && nums[i] != nums[nums[i]]) {
                    // Need to move
                    int temp = nums[nums[i]]; 
                    nums[nums[i]] = nums[i]; 
                    nums[i] = temp; 
                    i--; 
                } else {
                    last = i; 
                }
            }
            
            i++; 
        }
        
        if (last == -1) {
            return len; 
        }
        
        return last; 
    }
}
