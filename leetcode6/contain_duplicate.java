/**
 * Check if there is any duplicates in the given array. 
 * This is the naive approach. Put all the elements in a set, thus 
 * all duplicates will be removed. If the resulting set has different size 
 * comparing to the input array, then there must be duplicates in the array. 
 */ 
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) {
            return false; 
        }
        
        Set<Integer> s = new HashSet<>(); 
        
        for (int item : nums) {
            s.add(item); 
        }
        
        return nums.length != s.size(); 
    }
}
