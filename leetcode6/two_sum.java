/**
 * Find the two sum that adds up to the given target. 
 * Do not sort becuase you will mess up with index. 
 * Naive solution is O(n^2) algorithm. 
 */ 
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int len = nums.length; 
        int i = 0;
        
        while (i < len - 1) {
        	int j = i + 1; 
        	
        	while (j < len) {
        		
        		if (nums[i] + nums[j] == target) {
        			result[0] = i + 1; 
        			result[1] = j + 1; 
        			return result; 
        		}
        		
        		j++; 
        	}
        	
        	i++; 
        }
        
        return result; 
    }
}
