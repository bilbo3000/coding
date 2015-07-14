/**
 * Find the majority element in an array. The majority element appear 
 * more than Math.floor(n / 2) times. 
 * The idea was to maintain a map from the element to its count. While
 * iterating through the array, increase the corresonding count. Return 
 * the element immediately when the count qualifies for the majority 
 * element. 
 */
public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>(); 
        
        for (int item : nums) {
            if (!count.containsKey(item)) {
                count.put(item, 0); 
            }
            
            count.put(item, count.get(item) + 1); 
            
            if (count.get(item) > Math.floor(nums.length / 2)) {
                return item; 
            }
        }
        
        return 0; 
    }
}
