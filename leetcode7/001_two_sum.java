/**
Find the two indices from an array where elements sum is equal to the given target. 

The solution is going through the array in one pass and use a hash table to keep 
track of the element to its index have seen. If any elements we've seen in the past 
plus the current element is equal to the target, we found the solution. 

This solution will deal with duplicates correctly: the most recent duplicates 
seen so far will overwrite previous ones. Thus the latest one is used. 

Time: O(n); 
Space: O(n); 
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null; 
        }
        
        Map<Integer, Integer> m = new HashMap<Integer, Integer>(); 
        int[] result = new int[]{-1, -1};
        
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(target - nums[i])) {
                result[0] = m.get(target - nums[i]);
                result[1] = i; 
                return result; 
            } else {
                m.put(nums[i], i);
            }
        }
        
        return result; 
    }
}
