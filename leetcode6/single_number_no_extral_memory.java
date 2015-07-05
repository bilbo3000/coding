/**
 * In order to not use extra member, we have to take advantage of the input array itself. 
 * The idea is to loop through the input array backwards start from the second from the last
 * item. XOR current item and the one after it, then put the result at the current position. 
 * By traversing backwards, the result can be accumulated and carried over all the way to the 
 * beginning. When the loop finishes, return the first element in the input array, that would 
 * be the result. 
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int len = nums.length; 
        
        if (len == 0) {
            return 0; 
        }
        
        if (len > 0) {
            for (int i = len - 2; i >= 0; i--) {
                nums[i] = nums[i] ^ nums[i + 1]; 
            }
        }
        
        return nums[0];
    }
}
