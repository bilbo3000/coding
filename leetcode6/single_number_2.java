/**
 * Find the single number that does not appear three times. 
 * Bitwise operation. The idea was to create three variables: 
 * one: ALL the number the appear once; 
 * two: ALL the number that appear twice; 
 * three: ALL the number that appear three times; 
 * While iterating through the list, need to do the following actions: 
 * 1) Update two: two |= one & x; // If the number already appear once, add it to two.
 * 2) Update one: one = one ^ x; // If the number already appearr once, remove it from one.
 * 3) Update three: three = two & one; // ALL number appear three times should be numbers that
 *                                     // appear twice and appear once. 
 * 4) Clean up one: one &= ~three; // ALL the number appear three times should not in one; 
 * 5) Clean up two: two &= ~three; // ALL the number appear three times should not in two; 
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int one = 0; 
        int two = 0; 
        int three = 0; 
        
        for (int item : nums) {
            two |= item & one; // Update two 
            one = item ^ one;  // Update one
            three = two & one; // Update three 
            two &= ~three; // Reset two
            one &= ~three; // Reset one
        }
        
        return one; 
    }
}
